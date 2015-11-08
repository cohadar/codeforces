import java.util.*;
import java.io.*;

/** 
 * @author Mighty Cohadar 
 * @link http://codeforces.com/problemset/problem/593/A
 */
public class A {

	static class Data {
		final Character a;
		final Character b;
		final int na;
		final int nb;
		Data(Character a, Character b, int na, int nb) {
			this.a = a;
			this.b = b;
			this.na = na;
			this.nb = nb;
		}
		public String toString() {
			return String.format("(a='%c', b='%c', na=%d, nb=%d)", a, b, na, nb);
		}	
		static Data fromString(String s) {
			Character a = null;
			Character b = null;
			int na = 0;
			int nb = 0;
			char[] ca = s.toCharArray();
			for (char c : ca) {
				if (a == null || a == c) {
					a = c;
					na++;
				} else if (b == null || b == c) {
					b = c;
					nb++;
				} else {
					return null;
				}
			}
			if (b == null || a <= b) {
				return new Data(a, b, na, nb);
			} else {
				return new Data(b, a, nb, na);
			}
		}
	}

	static int count(List<Data> dataz, char a, char b) { 
		int ret = 0;
		for (Data d : dataz) {
			if (d.b == null) {
				if (d.a == a || d.a == b) {
					ret += d.na;
				}
			} else if (d.a == a && d.b == b) {
				ret += d.na;
				ret += d.nb;
			}
		}
		return ret;
	}	

	static int solve(List<Data> dataz) {
		debug(dataz);
		int max = 0;
		for (char a = 'a'; a < 'z'; a++) {
			for (char b = (char)(a + 1); b <= 'z'; b++) {
				max = Math.max(max, count(dataz, a, b));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		List<Data> dataz = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Data d = Data.fromString(scanner.nextLine());
			if (d != null) {
				dataz.add(d);
			}
		}
		System.out.println(solve(dataz));
	}

	static boolean DEBUG = false;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

