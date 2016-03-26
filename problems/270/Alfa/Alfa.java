import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static boolean solve(int x) {
		if (x >= 180) {
			return false;
		}
		return 360 % (180 - x) == 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-->0) {
			int x = scanner.nextInt();
			System.out.println((solve(x)) ? "YES" : "NO");
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

