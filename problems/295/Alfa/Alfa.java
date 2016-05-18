import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nn = scanner.nextInt();
		int no = scanner.nextInt();
		int nq = scanner.nextInt();
		long[] A = new long[nn];
		for (int i = 0; i < nn; i++) {
			A[i] = scanner.nextInt();
		}
		int[] L = new int[no];
		int[] R = new int[no];
		int[] D = new int[no];
		for (int i = 0; i < no; i++) {
			L[i] = scanner.nextInt() - 1;
			R[i] = scanner.nextInt() - 1;
			D[i] = scanner.nextInt();
		}
		int[] X = new int[nq];
		int[] Y = new int[nq];
		for (int i = 0; i < nq; i++) {
			X[i] = scanner.nextInt() - 1;
			Y[i] = scanner.nextInt() - 1;
		}
		// solve
		FenwickTree QT = new FenwickTree(no);
		for (int i = 0; i < nq; i++) {
			int x = X[i];
			int y = Y[i];
			QT.addValueToRange(x + 1, y + 1, 1);
		}
		long[] Q = QT.toArray();
		FenwickTree AT = new FenwickTree(nn);
		for (int i = 0; i < A.length; i++) {
			AT.addValue(i + 1, A[i]);
		}
		for (int j = 0; j < no; j++) {
			int l = L[j];
			int r = R[j];
			int d = D[j];
			long q = Q[j];
			AT.addValueToRange(l + 1, r + 1, d * q);
		}
		System.out.println(join(" ", AT.toArray()));
	}

	static String join(String delimiter, long[] A) {
		StringBuilder sb = new StringBuilder();
		for (long a : A) {
			sb.append(a);
			sb.append(delimiter);
		}
		sb.setLength(Math.max(0, sb.length() - delimiter.length()));
		return sb.toString();
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

	public static void assertEquals(long[] A, long[] B) {
		for (int i = 0; i < A.length; i++) {
			assert A[i] == B[i];
		}
	}
	
}

class FastScanner {
	private final BufferedReader in;
	private final StringBuilder sb;
	private StringTokenizer strtok;
	public FastScanner(InputStream is) {
		this.in = new BufferedReader(new InputStreamReader(is));
		this.sb = new StringBuilder();
		this.strtok = null;
	}
	public String next() {
		try {
			if (strtok == null || strtok.hasMoreTokens() == false) {
				strtok = new StringTokenizer(in.readLine());
			}
			return strtok.nextToken();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public long nextLong() {
		return Long.parseLong(next());
	}
	public String nextLine() {
		try {
			if (strtok == null) {
				return in.readLine();
			} else {
				String ret = (strtok.hasMoreTokens()) ? strtok.nextToken("\n") : "";
				strtok = null;
				return ret;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

/**
* All indexes in FenwickTree are 1-based.
*/
class FenwickTree {
	private final long[] add;
	private final long[] mul;
	private final long[] min;
	private final long[] max;
	private final int n;

	public FenwickTree(int n) {
		this.add = new long[1 + n];
		this.mul = new long[1 + n];
		this.min = new long[1 + n];
		this.max = new long[1 + n];
		Arrays.fill(this.min, Long.MAX_VALUE);
		Arrays.fill(this.max, Long.MIN_VALUE);
		this.n = n;
	}

	private void internalUpdate(final int index, long factor, long delta) {
		assert index > 0 && index <= n;
		long oldMin = getMin(index);
		long oldMax = getMax(index);
		for (int i = index; i <= n; i += (i & -i)) {
			mul[i] += factor;
			add[i] += delta;
		}
		long newValue = getValue(index);
		if (newValue < oldMin) {
			for (int i = index; i <= n; i += (i & -i)) {
				min[i] = newValue;
			}
		}
		if (newValue > oldMax) {
			for (int i = index; i <= n; i += (i & -i)) {
				max[i] = newValue;
			}
		}
	}

	// @return sum(A[1]..A[index])
	public long getSum(final int index) {
		assert index >= 0 && index <= n;
		long sum = 0;
		long fact = 0;
		for (int i = index; i > 0; i -= (i & -i)) {
			sum += add[i];
			fact += mul[i];
		}
		return fact * index + sum;		
	}

	// @return min(A[1]..A[index])
	public long getMin(final int index) {
		assert index > 0 && index <= n;
		long m = min[index];
		for (int i = index - (index & -index); i > 0; i -= (i & -i)) {
			m = Math.min(m, min[i]);
		}
		return m;
	}	

	// @return max(A[1]..A[index])
	public long getMax(final int index) {
		assert index > 0 && index <= n;
		long m = max[index];
		for (int i = index - (index & -index); i > 0; i -= (i & -i)) {
			m = Math.max(m, max[i]);
		}
		return m;
	}		

	// @return sum(A[low]..A[high])
	public long getRangeSum(int low, int high) {
		assert low <= high;
		return getSum(high) - getSum(low - 1);
	}

	// @return A[index]
	public long getValue(int index) {
		assert index > 0 && index <= n;
		return getSum(index) - getSum(index - 1);
	}	

	// A[index] += value
	public void addValue(int index, long value) {
		internalUpdate(index, 0, value);
	}	

	// for (int i = low; i <= high; i++) A[i] += value
	public void addValueToRange(int low, int high, long value) {
		internalUpdate(low, value, -value * (low - 1));
		internalUpdate(high, -value, value * high); 
	}

	// @return min index, where getSum(index) > sum
	long findHigherSumIndex(long sum) {
		int low = 1;
		int high = n + 1;
		while (low < high) {
			int mid = (low + high) >>> 1;
			long midSum = getSum(mid);
			if (midSum <= sum) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return high;
	}	

	// @return A[]
	public long[] toArray() {
		long[] A = new long[n];
		long cumul = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = this.getSum(i + 1) - cumul;
			cumul += A[i];
		}
		return A;
	}

}
