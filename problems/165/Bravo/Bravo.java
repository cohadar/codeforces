import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static boolean ok(int n, int k, int v) {
		long z = 0;
		while (v > 0) {
			z += v;
			v /= k;
		}
		return z >= n;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int l = 1;
		int r = n;
		while (l < r) {
			int m = (l + r) >>> 1;
			if (ok(n, k, m)) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		System.out.println(r);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

