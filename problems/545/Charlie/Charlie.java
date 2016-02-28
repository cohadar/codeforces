import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] X = new int[n];
		int[] H = new int[n];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int h = scanner.nextInt();
			assert 1 <= x && x <= 1e9 : "out of range, x: " + x;
			assert 1 <= h && h <= 1e9 : "out of range, h: " + h;
			X[i] = x;
			H[i] = h;
		}
		if (n <= 2) {
			System.out.println(n);
			return;
		}
		int count = 2;
		int xr = X[n - 1];
		for (int i = n - 2; i >= 1; i--) {
			int xl = X[i - 1];
			if (X[i] + H[i] < xr) {
				count++;
				xr = X[i];
			} else if (xl < X[i] - H[i]) {
				count++;
				xr = X[i] - H[i];
			} else {
				xr = X[i];
			}
		}
		System.out.println(count);
	}

}

