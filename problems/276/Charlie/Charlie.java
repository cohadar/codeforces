import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nn = scanner.nextInt();
		int qq = scanner.nextInt();
		// radix sort
		int[] A = new int[200_000 + 1];
		for (int i = 0; i < nn; i++) {
			A[scanner.nextInt()]++;
		}
		FenwickTree FT = new FenwickTree(200_000);
		for (int i = 0; i < qq; i++) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			FT.addValueToRange(l, r, 1);
		}
		int[] F = FT.toArray();
		Arrays.sort(F);
		long sum = 0;
		int j = A.length - 1;
		outer:
		for (int i = F.length - 1; i >= 0; i--) {
			while (A[j] == 0) {
				j--;
				if (j < 0) {
					break outer;
				}
			}
			A[j]--;
			sum += (long)j * F[i];
		}
		System.out.println(sum);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

/**
* All indexes in FenwickTree are 1-based.
*/
class FenwickTree {
	private final int[] add;
	private final int[] mul;
	private final int[] min;
	private final int[] max;
	private final int n;

	public FenwickTree(int n) {
		this.add = new int[1 + n];
		this.mul = new int[1 + n];
		this.min = new int[1 + n];
		this.max = new int[1 + n];
		Arrays.fill(this.min, Integer.MAX_VALUE);
		Arrays.fill(this.max, Integer.MIN_VALUE);
		this.n = n;
	}

	public FenwickTree(int[] A) {
		this(A.length);
		for (int i = 0; i < A.length; i++) {
			this.addValue(i + 1, A[i]);
		}
	}	

	private void internalUpdate(final int index, int factor, int delta) {
		assert index > 0 && index <= n;
		int oldMin = getMin(index);
		int oldMax = getMax(index);
		for (int i = index; i <= n; i += (i & -i)) {
			mul[i] += factor;
			add[i] += delta;
		}
		int newValue = getValue(index);
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
	public int getSum(final int index) {
		assert index >= 0 && index <= n;
		int sum = 0;
		int fact = 0;
		for (int i = index; i > 0; i -= (i & -i)) {
			sum += add[i];
			fact += mul[i];
		}
		return fact * index + sum;		
	}

	// @return min(A[1]..A[index])
	public int getMin(final int index) {
		assert index > 0 && index <= n;
		int m = min[index];
		for (int i = index - (index & -index); i > 0; i -= (i & -i)) {
			m = Math.min(m, min[i]);
		}
		return m;
	}	

	// @return max(A[1]..A[index])
	public int getMax(final int index) {
		assert index > 0 && index <= n;
		int m = max[index];
		for (int i = index - (index & -index); i > 0; i -= (i & -i)) {
			m = Math.max(m, max[i]);
		}
		return m;
	}		

	// @return sum(A[low]..A[high])
	public int getRangeSum(int low, int high) {
		assert low <= high;
		return getSum(high) - getSum(low - 1);
	}

	// @return A[index]
	public int getValue(int index) {
		assert index > 0 && index <= n;
		return getSum(index) - getSum(index - 1);
	}	

	// A[index] += value
	public void addValue(int index, int value) {
		internalUpdate(index, 0, value);
	}	

	// for (int i = low; i <= high; i++) A[i] += value
	public void addValueToRange(int low, int high, int value) {
		internalUpdate(low, value, -value * (low - 1));
		internalUpdate(high, -value, value * high); 
	}

	// @return min index, where getSum(index) > sum
	int findHigherSumIndex(int sum) {
		int low = 1;
		int high = n + 1;
		while (low < high) {
			int mid = (low + high) >>> 1;
			int midSum = getSum(mid);
			if (midSum <= sum) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return high;
	}	

	// @return A[]
	public int[] toArray() {
		int[] A = new int[n];
		int cumul = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = this.getSum(i + 1) - cumul;
			cumul += A[i];
		}
		return A;
	}

}


class FastScanner {
	private final InputStream is;
	private final byte[] buff = new byte[1024];
	private int i;
	private int n;
	public FastScanner(InputStream is) {
		this.is = is;
	}
	private int read() {
		if (n == -1) {
			throw new InputMismatchException("<EOF>");
		}
		if (i >= n) {
			i = 0;
			try {
				n = is.read(buff);
			} catch (IOException e) {
				throw new InputMismatchException(e.getMessage());
			}
			if (n <= 0) {
				return -1;
			}
		}
		return buff[i++];
	}
	private void unread() {
		i--;
		if (i < 0) {
			throw new InputMismatchException("unread");
		}
	}
	private int skipWhitespace() {
		while (true) {
			int c = read();
			if (Character.isWhitespace(c) == false) {
				return c;
			}
		}
	}
	public int nextInt() {
		int c = skipWhitespace();
		boolean negative = false;
		if (c == '-') {
			negative = true;
			c = read();
		}
		int res = 0;
		while (Character.isDigit(c)) {
			res = res * 10 + (c - '0');
			c = read();
		};
		if (c != -1) {
			unread();
		}
		return (negative) ? -res : res;
	}
	public long nextLong() {
		int c = skipWhitespace();
		boolean negative = false;
		if (c == '-') {
			negative = true;
			c = read();
		}
		long res = 0;
		while (Character.isDigit(c)) {
			res = res * 10 + (c - '0');
			c = read();
		};
		if (c != -1) {
			unread();
		}
		return (negative) ? -res : res;
	}	
	public String next() {
		StringBuilder sb = new StringBuilder();
		int c = skipWhitespace();
		while (true) {
			sb.append((char)c);
			c = read();
			if (c == -1 || Character.isWhitespace(c)) {
				break;
			}
		};
		if (c != -1) {
			unread();
		}
		return sb.toString();
	}		
	public String nextLine() {
		StringBuilder sb = new StringBuilder();
		while (true) {
			int c = read();
			if (c == '\r') {
				c = read();
				if (c != '\n' && c != -1) {
					unread();
					c = '\n';
				}
			}
			if (c == '\n' || c == -1) {
				break;
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
}

