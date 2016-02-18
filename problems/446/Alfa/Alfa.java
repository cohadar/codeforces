import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		int[] L = new int[n];
		int[] F = new int[n];
		int[] T = new int[n];
		L[0] = 1;
		F[0] = 1;
		T[0] = 1;
		for (int k = 1; k < n; k++) {
			// L
			int max = L[k-1];
			if (A[k-1] < A[k]) {
				max = Math.max(max, 1 + T[k-1]);
			} else {
				max = Math.max(max, 1 + F[k-1]);
				max = Math.max(max, T[k-1]);
			}
			L[k] = max;
			// F
			max = 1;
			if (A[k-1] < A[k]) {
				max = Math.max(max, 1 + F[k-1]);
			}
			F[k] = max;
			// T
			max = F[k-1];
			if (A[k-1] < A[k]) {
				max = Math.max(max, 1 + T[k-1]);
			} else {
				if (k == n-1 || A[k+1] - A[k-1] >= 2) {
					max = Math.max(max, 1 + F[k-1]);
				}
			}
			T[k] = max;
		}
		debug('A', A);
		debug('L', L);
		debug('T', T);
		debug('F', F);
		System.out.println(L[n-1]);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

