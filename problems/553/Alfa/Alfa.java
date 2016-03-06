import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static final int PRIME = (int)1e9 + 7;

	static long[][] binomial(int max_n) {
		long[][] B = new long[max_n + 1][max_n + 1];
		for (int n = 0; n < B.length; n++) {
			B[n][0] = 1;
			B[n][n] = 1;
		}
		for (int n = 0; n < B.length; n++) {
			for (int k = 1; k < n; k++) {
				B[n][k] = B[n - 1][k] + B[n - 1][k - 1];
				B[n][k] %= PRIME;
			}
		}
		return B;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		assert 1 <= k && k <= 1000 : "out of range, k: " + k;
		int[] A = scanArray(scanner, k);
		long[][] B = binomial(1000);
		long mul = 1;
		int cumul = A[0];
		for (int x = 1; x < k; x++) {
			cumul += A[x];
			int d = A[x] - 1;
			int u = cumul - 1;
			mul *= B[u][d];
			mul %= PRIME;
		}
		System.out.println(mul);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1000 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

