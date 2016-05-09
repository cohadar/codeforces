import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final char[] C;
	final TreeSet<Interval> T = new TreeSet<>();
	private int sum;
	
	public Charlie(char[] C) {
		this.C = C;
		int l = -1;
		for (int r = 0; r < C.length; r++) {
			if (C[r] == '.') {
				if (l == -1) {
					l = r;
				}
			} else {
				if (l != -1) {
					T.add(new Interval(l, r - 1));
				}
				l = -1;
			}
		}
		if (l != -1) {
			T.add(new Interval(l, C.length - 1));
		}
		for (Interval i : T) {
			sum += i.price();
		}	
	}

	public void merge(int x) {
		Interval i = new Interval(x, x);
		Interval l = T.lower(i);
		Interval r = T.higher(i);
		if (l != null && r != null && l.r == x-1 && r.l == x+1) {
			sum -= l.price();
			sum -= r.price();
			Interval m = new Interval(l.l, r.r);
			sum += m.price();
			T.remove(l);
			T.remove(r);
			T.add(m);
		} else if (l != null && l.r == x-1) {
			sum -= l.price();
			Interval m = new Interval(l.l, x);
			sum += m.price();
			T.remove(l);
			T.add(m);
		} else if (r != null && r.l == x+1) {
			sum -= r.price();
			Interval m = new Interval(x, r.r);
			sum += m.price();
			T.remove(r);
			T.add(m);
		} else {
			T.add(i);
		}
	}

	public void divide(int x) {
		Interval i = new Interval(x, x);
		Interval l = T.floor(i);
		if (l != null && l.r >= x) {
			sum -= l.price();
			Interval a = new Interval(l.l, x - 1);
			Interval b = new Interval(x + 1, l.r);
			T.remove(l);
			if (!a.isEmpty()) {
				sum += a.price();
				T.add(a);
			}
			if (!b.isEmpty()) {
				sum += b.price();
				T.add(b);
			}
		}
	}	

	public int solve(int x, char c) {
		if (c == '.' && C[x] != '.') {
			merge(x);
		}
		if (c != '.' && C[x] == '.') {
			divide(x);
		}
		C[x] = c;
		return sum;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		char[] C = scanner.nextLine().toCharArray();
		assert C.length == n;
		Charlie o = new Charlie(C);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt() - 1;
			String c = scanner.next();
			sb.append(o.solve(x, c.charAt(0)));
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

class Interval implements Comparable<Interval> {
	final int l;
	final int r;
	Interval(int l, int r) {
		this.l = l;
		this.r = r;
	}
	public int compareTo(Interval that) {
		return Integer.compare(this.l, that.l);
	}
	public String toString() {
		return String.format("(l=%d, r=%d)", l, r);
	}	
	public int price() {
		return Math.max(0, this.r - this.l);
	}
	public boolean isEmpty() {
		return l > r;
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
