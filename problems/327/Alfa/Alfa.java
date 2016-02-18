import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		if (n == 1) {
			System.out.println(1 - A[0]);
			return;
		}
		int[] L = new int[n];
		int[] M = new int[n];
		int[] R = new int[n];
		R[0] = -INF;
		M[0] = 1 - A[0];
		L[0] = A[0];
		for (int k = 1; k < n; k++) {
			int r1 = A[k] + R[k-1];
			int r2 = A[k] + M[k-1];
			R[k] = Math.max(r1, r2);
			int m1 = 1 - A[k] + M[k-1];
			int m2 = 1 - A[k] + L[k-1];
			M[k] = Math.max(m1, m2);
			L[k] = A[k] + L[k-1];
		}
		System.out.println(Math.max(R[n-1], M[n-1]));
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 0 <= A[i] && A[i] <= 1 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

