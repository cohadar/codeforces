import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		long[] A = new long[1 + n];
		long[] B = new long[1 + n];
		long cumul = 0;
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			B[i] = a;
			cumul += a;
			A[1 + i] = cumul;
		}
		Arrays.sort(B);
		for (int i = 0; i < n; i++) {
			B[1 + i] += B[i];
		}
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		for (int i = 0; i < m; i++) {
			int t = scanner.nextInt();
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			System.out.println((t == 1) ? (A[r] - A[l - 1]) : (B[r] - B[l - 1]));
		}
	}

}
