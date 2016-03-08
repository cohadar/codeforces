import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	public static int[] seq(int n) {
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = i;
		}
		return A;
	}

	public static int[] factors(int[] A) {
		int[] B = new int[A.length];
		for (int i = 2; i < A.length; i++) {
			if (A[i] == 1) { continue; };
			for (int j = i; j < A.length; j += i) {
				while (A[j] % i == 0) {
					A[j] /= i;
					B[j]++;
				}	
			}
		}
		return B;
	}

	public static int[] cumul(int[] B) {
		int[] C = new int[B.length];
		int cumul = 0;
		for (int i = 0; i < B.length; i++) {
			cumul += B[i];
			C[i] = cumul;
		}
		return C;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int[] A = seq(1 + (int)5e6);
		int[] B = factors(A);
		int[] C = cumul(B);
		int t = scanner.nextInt();
		assert 1 <= t && t <= 1e6 : "out of range, t: " + t;
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			assert 1 <= a && a <= 5e6 : "out of range, a: " + a;
			assert 1 <= b && b <= 5e6 : "out of range, b: " + b;
			assert a >= b;
			sb.append(C[a] - C[b]);
			sb.append('\n');
		}
		System.out.println(sb);
	}

}

/***/
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

