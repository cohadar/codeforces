import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static int max(int... A) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
	}

	public static String solve(int n, final int d, final int h) {
		StringBuilder sb = new StringBuilder();
		// height branch
		int k = 2;
		int prev = 1;
		int h1 = 0;
		int h2 = 0;
		int h3 = 0;
		for (int i = 0; i < h; i++) {
			sb.append(String.format("%d %d\n", prev, k));
			prev = k++;
			h1++;
		}
		// distance branch
		prev = 1;
		for (int i = 0; i < d - h; i++) {
			sb.append(String.format("%d %d\n", prev, k));
			prev = k++;
			h2++;
		}
		// filler
		while (k <= n) {
			h3 = 1;
			sb.append(String.format("1 %d\n", k++));
		}
		int maxh = max(h1, h2, h3);
		int minh = max(h1, h2, h3);
		int sumh = h1 + h2 + h3;
		if (sumh - minh > d || h1 + h2 != d || maxh > h || k != n + 1) {
			return "-1";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int h = scanner.nextInt();
		assert 2 <= n && n <= 1e5 : "out of range, n: " + n;
		assert 1 <= h && h <= d : "out of range, h: " + h;
		assert h <= d && d <= n-1 : "out of range, d: " + d;
		System.out.println(solve(n, d, h));
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

