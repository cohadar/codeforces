import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		assert 1 <= n && n <= 200 : "out of range, n: " + n;
		char[] C = scanner.nextLine().toCharArray();
		int[] X = new int[1 + n];
		int[] Y = new int[1 + n];
		for (int i = 0; i < C.length; i++) {
			X[i + 1] = X[i];
			Y[i + 1] = Y[i];
			switch (C[i]) {
			case 'U':
				Y[i + 1]++;
				break;
			case 'D':
				Y[i + 1]--;
				break;
			case 'L':
				X[i + 1]--;
				break;
			case 'R':
				X[i + 1]++;
				break;
			}
		}
		int count = 0;
		for (int l = 0; l < n; l++) {
			for (int r = l + 1; r < n; r++) {
				int x = X[r + 1] - X[l];
				int y = Y[r + 1] - Y[l];
				if (x == 0 && y == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}

