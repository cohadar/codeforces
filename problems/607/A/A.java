import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static int numInRange(FenwickTree ft, int l, int r) {
		return ft.getRangeSum(l + 1, r + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int MAX_LEN = (int)1e6 + 1;
		int[] B = new int[MAX_LEN];
		FenwickTree ft = new FenwickTree(MAX_LEN);
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			B[a] = b;
			ft.addValue(1 + a, 1);
		}
		int[] D = new int[MAX_LEN];
		for (int i = 1; i < MAX_LEN; i++) {
			if (B[i] > 0) {
				D[i] = numInRange(ft, Math.max(0, i - B[i]), i - 1) + D[Math.max(0, i - B[i] - 1)];
			} else {
				D[i] = D[i - 1];
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < MAX_LEN; i++) {
			if (B[i] > 0) {
				res = Math.min(res, D[i] + numInRange(ft, i + 1, MAX_LEN - 1));
			}
		}
		System.out.println(res);
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
