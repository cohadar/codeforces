import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Echo {

	final List<List<Integer>> G;
	final int[] C; // color array
	
	public Echo(List<List<Integer>> G) {
		this.G = G;
		this.C = new int[G.size()];
	}
	
	public int solve() {
		int bad = 0;
		int color = 10000;
		for (int i = 0; i < C.length; i++) {
			if (C[i] == 0) {
				C[i] = color;
				if (hasACycle(i, color) == false) {
					bad++;	
				}
				color++;
			}
		}
		return bad;
	}

	public boolean hasACycle(int a, int color) {
		boolean ret = false;
		for (int b : G.get(a)) {
			if (C[b] == 0) {
				C[b] = color;
				G.get(b).remove(new Integer(a));
				ret |= hasACycle(b, color);	
			} else if (C[b] == color) {
				ret = true;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 1e5 : "out of range, n: " + n;
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		List<List<Integer>> G = scanGraph(scanner, n, m);
		Echo o = new Echo(G);
		System.out.println(o.solve());
	}

	static List<List<Integer>> scanGraph(FastScanner scanner, int n, int m) {
		List<List<Integer>> G = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			G.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			G.get(a).add(b);
			G.get(b).add(a);
		}		
		return G;
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

