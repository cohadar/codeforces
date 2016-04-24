import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int n;
	final int sw;
	final long shift;
	
	public Delta(int n, int sw, long shift) {
		this.n = n;
		this.sw = sw;
		this.shift = shift;
		assert sw == -1 || sw == 0 || sw == 1 : "bad sw: " + sw;
	}

	public int next(int index) {
		return (index + 1) % n;
	}

	public int prev(int index) {
		return (index - 1 + n) % n;
	}

	public int boy(long pos) {
		int index = (int)(pos % n);
		if (sw == 0) {
			return index;
		}
		if (sw == 1) {
			return (index % 2 == 0) ? next(index) : prev(index);
		}
		return (index % 2 == 0) ? prev(index) : next(index);
	}

	public String solve() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(boy(shift + i) + 1);
			sb.append(' ');
		}
		return sb.toString();
	}

	public static Delta load(FastScanner scanner) {
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		assert 2 <= n && n <= 1e6 : "out of range, n: " + n;
		assert 1 <= q && q <= 2e6 : "out of range, q: " + q;
		long prev = 0;
		long shift = 0;
		int sw = 0;
		for (int i = 0; i < q; i++) {
			int t = scanner.nextInt();
			if (t == 1) {
				int x = scanner.nextInt();
				prev = shift;
				shift += n;
				shift -= x;	
				shift %= n;				
			} else {
				if (shift % 2 == 0) {
					if (prev % 2 == 0) {
						sw = 1 - sw;
					} else {
						sw = -sw;
					}
				} else {
					if (prev % 2 != 0) {
						sw = 1 - sw;
					} else {
						sw = -1 - sw;
					}
				}
			}
		}
		return new Delta(n, sw, shift);
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
