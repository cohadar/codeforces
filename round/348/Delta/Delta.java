import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int n;
	final int l;
	final int r;
	
	public Delta(int n, int l, int r) {
		this.n = n;
		this.l = l;
		this.r = r;
	}

	public int index(int index) {
		return (index + n) % n;
	}

	public int boy(int i) {
		return (i % 2 == 0) ? index(i + l) : index(i + r);
	}

	public String solve() {
		debug(n, l, r);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(boy(i) + 1);
			sb.append(' ');
		}
		return sb.toString();
	}

	public static Delta load(FastScanner scanner) {
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		assert 2 <= n && n <= 1e6 : "out of range, n: " + n;
		assert 1 <= q && q <= 2e6 : "out of range, q: " + q;
		int l = 0;
		int r = 0;
		for (int i = 0; i < q; i++) {
			int t = scanner.nextInt();
			if (t == 1) {
				int x = scanner.nextInt();
				l += n;
				r += n;
				l += x;
				r += x;
				l %= n;				
				r %= n;				
			} else {
				int l1 = r + 1;
				int r1 = l - 1;
				l = l1;
				r = r1;
			}
		}
		return new Delta(n, l, r);
	} 

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
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
	public int nextint() {
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
