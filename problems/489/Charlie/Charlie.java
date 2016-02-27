import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		assert 1 <= m && m <= 100 : "out of range, m: " + m;
		int s = scanner.nextInt();
		assert 0 <= s && s <= 900 : "out of range, s: " + s;
		if (s > 9 * m || (s == 0 && m > 1)) {
			System.out.println("-1 -1");
			return;
		}
		if (m == 1 && s == 0) {
			System.out.println("0 0");
			return;
		}
		StringBuilder sb = new StringBuilder();
		int l = 0;
		for (int i = 0; i < m; i++) {
			int d = (s >= 9) ? 9 : s;
			sb.append(d);
			s -= d;
			if (d != 0) {
				l = i;
			}
		}
		String large = sb.toString();
		if (sb.charAt(m - 1) == '0') {
			sb.setCharAt(l, (char)(sb.charAt(l) - 1));
			sb.setCharAt(m - 1, '1');
		}
		String small = sb.reverse().toString();
		System.out.printf("%s %s", small, large);
	}

}

