import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) throws IOException {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		long[] A = new long[1 + n];
		long[] B = new long[1 + n];
		long cumul = 0;
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			B[i] = a;
			cumul += a;
			A[1 + i] = cumul;
		}
		Arrays.sort(B);
		for (int i = 0; i < n; i++) {
			B[1 + i] += B[i];
		}
		int m = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		for (int i = 0; i < m; i++) {
			int t = scanner.nextInt();
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			sb.append((t == 1) ? (A[r] - A[l - 1]) : (B[r] - B[l - 1]));
			sb.append('\n');
		}
		System.out.print(sb);
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
		return (negative) ? -res : res;
	}
}
