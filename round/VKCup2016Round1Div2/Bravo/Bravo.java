import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		TreeMap<Integer, Integer> VID = new TreeMap<>(); // value -> id
		TreeMap<Integer, Integer> IDV = new TreeMap<>(); // id -> value
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int q = scanner.nextInt();
		assert 1 <= n && n <= 150000 : "out of range, n: " + n;
		assert 1 <= q && q <= 150000 : "out of range, q: " + q;
		assert 1 <= k && k <= Math.min(6, 150000) : "out of range, k: " + k;
		int[] V = new int[1+n];
		for (int id = 1; id <= n; id++) {
			V[id] = scanner.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int type = scanner.nextInt();
			int id = scanner.nextInt();
			if (type == 1) {
				if (VID.size() < k) {
					VID.put(V[id], id);
					IDV.put(id, V[id]);
				} else {
					Map.Entry<Integer, Integer> l = VID.firstEntry();
					if (l.getKey() < V[id]) {
						VID.pollFirstEntry();
						IDV.remove(l.getValue());
						VID.put(V[id], id);
						IDV.put(id, V[id]);
					}
				}
			} else {
				if (IDV.containsKey(id)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb.toString());
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
