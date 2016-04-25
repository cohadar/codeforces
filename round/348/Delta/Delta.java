import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	static class State {
		final int val;
		final boolean swap;
		State(int val, boolean swap) {
			this.val = val;
			this.swap = swap;
		}
		public String toString() {
			return String.format("(val=%d, swap=%b)", val, swap);
		}	
	}

	public static State next(State state) {
		if (state.val == 0) {
			return new State(1, state.swap);
		} else {
			return new State(0, state.swap);
		}
	}

	public static State prev(State state) {
		if (state.val == 0) {
			return new State(-1, state.swap);
		} else {
			return new State(0, state.swap);
		}
	}

	public static State swap(State state) {
		return new State(state.val, !state.swap);
	}

	final int n;
	final State state;
	final long shift;
	
	public Delta(int n, State state, long shift) {
		this.n = n;
		this.state = state;
		this.shift = shift;
	}

	public int index(int index) {
		return (index + n) % n;
	}

	public int boy(long pos) {
		int i = (int)(pos % n);
		boolean even = (i % 2 == 0);
		switch (state.val) {
		case 0:
			if (state.swap) {
				return (even) ? index(i + 1) : index(i - 1);
			} else {
				return (even) ? index(i + 0) : index(i - 0);
			}
		case 1:
			if (state.swap) {
				return (even) ? index(i + 0) : index(i + 2);
			} else {
				return (even) ? index(i + 1) : index(i + 1);
			}
		case -1:
			if (state.swap) {
				return (even) ? index(i - 2) : index(i + 0);
			} else {
				return (even) ? index(i - 1) : index(i - 1);
			}
		default:
			throw new RuntimeException("Unknown option: " + (state.val));
		}
	}

	public String solve() {
		debug(shift, state);
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
		long shift = 0;
		State state = new State(0, false);
		for (int i = 0; i < q; i++) {
			int t = scanner.nextInt();
			if (t == 1) {
				int x = scanner.nextInt();
				shift += n;
				shift -= (x & ~1);	
				shift %= n;				
				switch (-x % 2) {
				case 0:
					// none
					break;
				case 1:
					state = next(state);
					break;
				case -1:
					state = prev(state);
					break;
				}
			} else {
				state = swap(state);
			}
		}
		return new Delta(n, state, shift);
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
