import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	static final int INF = Integer.MAX_VALUE / 2;

	static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static int get(int[] A, int w) {
		if (w < 0 || w >= A.length) {
			return (w % 2 == 0) ? -INF : INF;
		}
		return A[w];
	}

	public static boolean ok(int[] A, int w) {
		if (w % 2 == 0) {
			return (get(A, w) < get(A, w-1)) && (get(A, w) < get(A, w+1));	
		} else {
			return (get(A, w) > get(A, w-1)) && (get(A, w) > get(A, w+1));	
		}
	}

	public static boolean ok3(int[] A, int w) {
		return ok(A, w-1) && ok(A, w) && ok(A, w+1);
	}

	public static boolean ok(int[] A, Set<Integer> W) {
		for (Integer w : W) {
			if (ok3(A, w) == false) {
				return false;
			}
		}
		return true;
	}

	public static int solve(int[] A, Set<Integer> W) {
		int count = 0;
		for (Integer j : W) {
			for (int i = 0; i < j; i++) {
				if (W.contains(i)) {
					continue;
				}
				swap(A, i, j);
				if (ok(A, W) && ok3(A, i) && ok3(A, j)) {
					count++;
				}
				swap(A, i, j);
			}
		}
		for (Integer i : W) {
			for (int j = i+1; j < A.length; j++) {
				if (W.contains(j)) {
					continue;
				}				
				swap(A, i, j);
				if (ok(A, W) && ok3(A, i) && ok3(A, j)) {
					count++;
				}
				swap(A, i, j);
			}
		}		
		for (Integer i : W) {
			for (Integer j : W) {
				if (i >= j) {
					continue;
				}
				swap(A, i, j);
				if (ok(A, W) && ok3(A, i) && ok3(A, j)) {
					count++;
				}
				swap(A, i, j);
			}
		}				
		return count;
	}


	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 150000 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		Set<Integer> W = new HashSet<>();
		for (int i = 0; i < A.length - 1; i++) {
			if (i % 2 == 0) {
				if (A[i] >= A[i + 1]) {
					if (i > 0) {
						W.add(i - 1);
					}
					W.add(i);
					W.add(i+1);
				}
			} else {
				if (A[i] <= A[i + 1]) {
					if (i > 0) {
						W.add(i - 1);
					}
					W.add(i);
					W.add(i+1);
				}
			}
		}
		if (W.size() > 20) {
			System.out.println(0);
			return;
		}
		System.out.println(solve(A, W));
	}

	static int[] scanArray(FastScanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
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
