import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Echo {

	static final int PRIME = (int)1e9 + 7;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e7 : "out of range, n: " + n;
		long[] A = new long[2];
		long[] B = new long[2];
		long[] C = new long[2];
		long[] D = new long[2];
		A[1] = 1;
		B[1] = 1;
		C[1] = 1;
		D[1] = 0;
		for (int k = 2; k <= n; k++) {
			int c = k % 2;
			int p = 1 - c;
			A[c] = (B[p] + C[p] + D[p]) % PRIME;
			B[c] = (A[p] + C[p] + D[p]) % PRIME;
			C[c] = (A[p] + B[p] + D[p]) % PRIME;
			D[c] = (A[p] + B[p] + C[p]) % PRIME;
		}
		System.out.println(D[n % 2]);
	}

}

