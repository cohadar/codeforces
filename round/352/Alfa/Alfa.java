import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt() - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 1000; i++) {
			sb.append(i);
			if (sb.length() > n) {
				System.out.println(sb.charAt(n));
				return;
			}
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

