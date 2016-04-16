import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int packX(int im, int n) {
		if (im < 2 * n) {
			return (im % 2 == 0) ? 0 : 3;
		} else {
			return (im % 2 == 0) ? 1 : 2;
		}
	}

	public static int packY(int im, int n) {
		return (im % (2 * n)) / 2;
	}

	public static int unpackX(int x) {
		return (x < 2) ? x ^ 1 : x;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= m && m <= 4 * n : "out of range, m: " + m;
		Integer[][] B = new Integer[n][4];
		for (int im = 0; im < m; im++) {
			int x = packX(im, n);
			int y = packY(im, n);
			B[y][x] = im + 1;
		}
		
		for (int y = 0; y < n; y++) {
			for (int ix = 0; ix < 4; ix++) {
				int x = unpackX(ix);
				if (B[y][x] != null) {
					System.out.print(B[y][x]);
					System.out.print(' ');
				}
			}
		}
	}
	
}

