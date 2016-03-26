import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	static class Segment {
		final long miny;
		final long maxy;
		Segment(long yl, long yr) {
			this.miny = Math.min(yl, yr);
			this.maxy = Math.max(yl, yr);
		}
		public String toString() {
			return String.format("(miny=%d, maxy=%d)", miny, maxy);
		}	
	}

	public static boolean intersect(Segment a, Segment b) {
		if (a.maxy > b.miny && a.miny < b.maxy) {
			return true;
		}
		return false;
	}

	public static boolean solve(Segment[] S) {
		Arrays.sort(S, new Comparator<Segment> () {
			public int compare(Segment a, Segment b) {
				return Long.compare(a.miny, b.miny);
			}
		});
		for (int a = 0; a < S.length; a++) {
			for (int b = a + 1; b < S.length; b++) {
				if (intersect(S[a], S[b])) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 1e5 : "out of range, n: " + n;
		int x1 = scanner.nextInt();
		assert -1e6 <= x1 && x1 <= 1e6 : "out of range, x1: " + x1;
		int x2 = scanner.nextInt();
		assert -1e6 <= x2 && x2 <= 1e6 : "out of range, x2: " + x2;
		assert x1 < x2;
		Segment[] S = new Segment[n];
		for (int i = 0; i < n; i++) {
			int k = scanner.nextInt();
			assert -1e6 <= k && k <= 1e6 : "out of range, k: " + k;
			int b = scanner.nextInt();
			assert -1e6 <= b && b <= 1e6 : "out of range, b: " + b;
			long y1 = (long)k * x1 + b;
			long y2 = (long)k * x2 + b;
			S[i] = new Segment(y1, y2);
		}
		System.out.println((solve(S)) ? "YES" : "NO");
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

class FastScanner {
	private final InputStream is;
	private final byte[] buff = new byte[1024];
	private int i;
	private int n;
	public FastScanner(InputStream is) {
		this.is = is;
	}
	private int read() {
		if (n == -1) {
			throw new InputMismatchException("<EOF>");
		}
		if (i >= n) {
			i = 0;
			try {
				n = is.read(buff);
			} catch (IOException e) {
				throw new InputMismatchException(e.getMessage());
			}
			if (n <= 0) {
				return -1;
			}
		}
		return buff[i++];
	}
	private void unread() {
		i--;
		if (i < 0) {
			throw new InputMismatchException("unread");
		}
	}
	private int skipWhitespace() {
		while (true) {
			int c = read();
			if (Character.isWhitespace(c) == false) {
				return c;
			}
		}
	}
	public int nextInt() {
		int c = skipWhitespace();
		boolean negative = false;
		if (c == '-') {
			negative = true;
			c = read();
		}
		int res = 0;
		while (Character.isDigit(c)) {
			res = res * 10 + (c - '0');
			c = read();
		};
		if (c != -1) {
			unread();
		}
		return (negative) ? -res : res;
	}
	public long nextLong() {
		int c = skipWhitespace();
		boolean negative = false;
		if (c == '-') {
			negative = true;
			c = read();
		}
		long res = 0;
		while (Character.isDigit(c)) {
			res = res * 10 + (c - '0');
			c = read();
		};
		if (c != -1) {
			unread();
		}
		return (negative) ? -res : res;
	}	
	public String next() {
		StringBuilder sb = new StringBuilder();
		int c = skipWhitespace();
		while (true) {
			sb.append((char)c);
			c = read();
			if (c == -1 || Character.isWhitespace(c)) {
				break;
			}
		};
		if (c != -1) {
			unread();
		}
		return sb.toString();
	}		
	public String nextLine() {
		StringBuilder sb = new StringBuilder();
		while (true) {
			int c = read();
			if (c == '\r') {
				c = read();
				if (c != '\n' && c != -1) {
					unread();
					c = '\n';
				}
			}
			if (c == '\n' || c == -1) {
				break;
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
}
