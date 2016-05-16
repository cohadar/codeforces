import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static boolean solve(int a, int b, int c) {
		if (c == 0) {
			return a == b;
		}
		if ((b - a) % c == 0) {
			return (b - a) / c >= 0;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		System.out.println((solve(a, b, c)) ? "YES" : "NO");
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

