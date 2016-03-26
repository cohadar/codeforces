import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alpha {

	public static int rhomb(int a, int b) {
		return 2 * a * b;
	}

	public static int tri(int a) {
		return a * a;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int e = scanner.nextInt();
		int f = scanner.nextInt();
		System.out.println(rhomb(b + a, c + d) - tri(a) - tri(d));
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

