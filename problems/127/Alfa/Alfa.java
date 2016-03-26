import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 100 : "out of range, n: " + n;
		int k = scanner.nextInt();
		assert 1 <= k && k <= 1000 : "out of range, k: " + k;
		double distance = 0.0;
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		for (int i = 1; i < n; i++) {
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			distance += Math.hypot(x2 - x, y2 - y);
			x = x2;
			y = y2;
		}
		distance *= k;
		System.out.println(distance / 50);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

