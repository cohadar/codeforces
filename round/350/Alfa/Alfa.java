import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e6 : "out of range, n: " + n;
		int d = n / 7 * 2;
		int r = n % 7;
		int min = d;
		int max = d + 2;
		if (r == 6) {
			min = d + 1;
		}
		if (r == 0) {
			max = d;
		}
		if (r == 1) {
			max = d + 1;
		}
		System.out.printf("%d %d", min, max);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

