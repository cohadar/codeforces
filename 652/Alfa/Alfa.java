import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int h1 = scanner.nextInt();
		int h2 = scanner.nextInt();
		assert 1 <= h1 && h1 < h2 : "out of range, h1: " + h1;
		assert h1 < h2 && h2 <= 1e5 : "out of range, h2: " + h2;
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		assert 1 <= a && a <= 1e5 : "out of range, a: " + a;
		assert 1 <= b && b <= 1e5 : "out of range, b: " + b;
		if (a <= b) {
			if (h1 + a * 8 >= h2) {
				System.out.println(0);
			} else {
				System.out.println(-1);
			}
			return;
		}
		int k = 0;
		for (int t = 15; t < 1_000_000_000; t++) {
			int h = t % 24;
			if (11 <= h && h <= 22) {
				h1 += a;
			} else {
				h1 -= b;
			}
			if (h == 1) {
				k++;
			}
			if (h1 >= h2) {
				break;
			}
		}
		System.out.println(k);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

