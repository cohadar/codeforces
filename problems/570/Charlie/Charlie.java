import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	private int sum;
	final int n;
	final boolean[] B;
	
	public Charlie(int sum, boolean[] B) {
		this.sum = sum;
		this.n = B.length;
		this.B = B;
	}

	public int solve(int x, boolean b) {
		if (B[x] == b) {
			return sum;
		}
		if (b) {
			if (x > 0 && B[x-1]) {
				sum++;
			}
			if (x < n-1 && B[x+1]) {
				sum++;
			}			
		} else {
			if (x > 0 && B[x-1]) {
				sum--;
			}
			if (x < n-1 && B[x+1]) {
				sum--;
			}						
		}
		B[x] = b;
		return sum;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		char[] C = scanner.nextLine().toCharArray();
		boolean[] B = new boolean[C.length];
		int sum = 0;
		int len = 0;
		for (int i = 0; i < C.length; i++) {
			B[i] = C[i] == '.';
			if (B[i]) {
				len++;
				if (len > 1) {
					sum++;
				}
			} else {
				len = 0;
			}
		}
		Charlie o = new Charlie(sum, B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt() - 1;
			String c = scanner.next();
			sb.append(o.solve(x, c.charAt(0) == '.'));
			sb.append('\n');
		}
		System.out.print(sb);
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
