import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int[] cumul(int[] A) {
		int[] C = new int[1 + A.length];
		int cumul = 0;
		for (int i = 0; i < A.length; i++) {
			cumul += A[i];
			C[1 + i] = cumul;
 		}
		return C;
	}

	public static int upperBound(int[] A, int l, int r, int val) {
		while (l <= r) {
			int m = (l + r) >>> 1;
			if (A[m] > val) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int t = scanner.nextInt();
		assert 1 <= t && t <= 1e9 : "out of range, t: " + t;
		int[] A = scanArray(scanner, n);
		int[] C = cumul(A);
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			int ti = C[1 + i - 1];
			int u = upperBound(C, 1 + i, C.length - 1, ti + t) - 1;
			max = Math.max(max, u - i);
		}
		System.out.println(max);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e4 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

