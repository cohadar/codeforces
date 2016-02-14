import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static int solve(int max, int[] D, int[] H, int m) {
		for (int i = 1; i < m; i++) {
			int hl = H[i - 1];
			int hr = H[i];
			int l = D[i - 1];
			int r = D[i];
			if (l == r && hl != hr) {
				return -1;
			}
			if (Math.abs(hr - hl) > (r - l)) {
				return -1;
			}
			int h = ((r - l) + hr + hl) / 2;
			max = Math.max(max, h);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] D = new int[m];
		int[] H = new int[m];
		for (int i = 0; i < m; i++) {
			D[i] = scanner.nextInt();
			H[i] = scanner.nextInt();
		}
		int max = H[0];
		max = Math.max(max, H[0] + D[0]);
		max = Math.max(max, H[m - 1] + n - 1 - D[m - 1]);
		int s = solve(max, D, H, m);
		System.out.println((s == -1) ? "IMPOSSIBLE" : s);
	}

}

