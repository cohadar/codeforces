import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		assert 1 <= m * k && m * k <= 1e5 : "out of range, m * k: " + m * k;
		long[] C = new long[1 + n];
		for (int i = 1; i <= n; i++) {
			C[i] = C[i - 1] + scanner.nextInt();
		}
		long[][] D = new long[2][1 + n];
		for (int y = 1; y <= k; y++) {
			int c = y % 2;
			for (int x = y * m; x <= n; x++) {
				D[c][x] = D[c][x - 1];
				long temp = D[1 - c][x - m] + C[x] - C[x - m];
				D[c][x] = Math.max(D[c][x], temp);
			}
		}
		System.out.println(D[k % 2][n]);
	}

}

