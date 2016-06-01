import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	static final int PRIME = (int)1e9 + 7;

	public static int convert(char c) {
		if (c == '-') {
			return 62;
		} else if (c == '_') {
			return 63;
		} else if (c >= 'a') {
			return c - 'a' + 36;
		} else if (c >= 'A') {
			return c - 'A' + 10;
		}
		return c - '0';
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		long sum = 0;
		for (int i = 0; i < C.length; i++) {
			sum += (6 - Integer.bitCount(convert(C[i])));
		}
		long p = 1;
		for (int i = 0; i < sum; i++) {
			p *= 3;
			p %= PRIME;
		}
		System.out.println(p);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

