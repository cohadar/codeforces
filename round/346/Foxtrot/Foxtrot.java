import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Foxtrot {

	public static int[] findH(int[][] A, int n, int m, long k) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				int h = A[y][x];
				if (k % h == 0) {
					long d = k / h;
					if (d <= n * m) {
						return new int[] { h, y, x };
					}
				}
			}
		}
		return new int[] { -1, 0, 0 };
	}

	public static int[][] stack(int n, int m, int h, long d, int cy, int cx) {
		int[][] D = new int[n][m];
		D[cy][cx] = h;
		d--;
		outer:
		for (int y = cy - 1; y >= 0; y--) {
			if (d > 0) {
				d--;
				D[y][cx] = h;
			} else {
				break;
			}
			for (int x = cx + 1; x < m; x++) {
				if (d > 0) {
					d--;
					D[cy][cx] = h;
				} else {
					break outer;
				}				
			}
			for (int x = cx - 1; x >= 0; x--) {
				if (d > 0) {
					d--;
					D[cy][cx] = h;
				} else {
					break outer;
				}				
			}			
		}
		outer2:
		for (int y = cy + 1; y < n; y++) {
			if (d > 0) {
				d--;
				D[y][cx] = h;
			} else {
				break;
			}
			for (int x = cx + 1; x < m; x++) {
				if (d > 0) {
					d--;
					D[cy][cx] = h;
				} else {
					break outer2;
				}				
			}
			for (int x = cx - 1; x >= 0; x--) {
				if (d > 0) {
					d--;
					D[cy][cx] = h;
				} else {
					break outer2;
				}				
			}			
		}	
		return D;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		assert 1 <= m && m <= 1000 : "out of range, m: " + m;
		long k = scanner.nextLong();
		assert 1 <= k && k <= 1e18 : "out of range, k: " + k;
		int[][] A = new int[n][m];
		long sum = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				A[y][x] = scanner.nextInt();
				sum += A[y][x];
			}
		}
		if (sum < k) {
			System.out.println("NO");
			return;
		}
		int h[] = findH(A, n, m, k);
		if (h[0] <= 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			int[][] S = stack(n, m, h[0], k / h[0], h[1], h[2]);
			StringBuilder sb = new StringBuilder();
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					sb.append(S[y][x]);
					if (x == m-1) {
						sb.append('\n');
					} else {
						sb.append(' ');
					}
				}
			}
			System.out.println(sb);
		}
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

