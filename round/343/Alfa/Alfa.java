import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static int n2(int n) {
		return n * (n - 1) / 2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		char[][] C = new char[n][n];
		for (int i = 0; i < n; i++) {
			C[i] = scanner.nextLine().toCharArray();
			assert C.length == n;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			int rc = 0;
			int cc = 0;
			for (int j = 0; j < n; j++) {
				if (C[i][j] == 'C') {
					rc++;
				}
				if (C[j][i] == 'C') {
					cc++;
				}
			}
			count += n2(rc) + n2(cc);
		}
		System.out.println(count);
	}

}

