import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		assert 1 <= n && n <= 4000 : "out of range, n: " + n;
		int[] D = new int[1 + n];
		for (int k = 1; k <= n; k++) {
			D[k] = -INF;
			if (k >= a) { D[k] = Math.max(D[k], 1 + D[k - a]); }
			if (k >= b) { D[k] = Math.max(D[k], 1 + D[k - b]); }
			if (k >= c) { D[k] = Math.max(D[k], 1 + D[k - c]); }
		}
		System.out.println(D[n]);
	}

}

