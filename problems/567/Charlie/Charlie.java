import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static boolean add(Map<Long, Integer> M, Long key) {
		Integer count = M.get(key);
		if (count == null) {
			M.put(key, 1);	
			return true;
		} else {
			M.put(key, count + 1);
			return false;
		}
	}
	
	public static boolean remove(Map<Long, Integer> M, Long key) {
		Integer count = M.get(key);
		if (count == null) {
			return false;
		}
		count--;
		if (count == 0) {
			M.remove(key);
		} else {
			M.put(key, count);
		}
		return true;
	}
	
	public static int count(Map<Long, Integer> M, Long key) {
		Integer count = M.get(key);
		return (count == null) ? 0 : count;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nn = scanner.nextInt();
		long kk = scanner.nextLong();
		long[] A = new long[nn];
		TreeMap<Long, Integer> L = new TreeMap<>();
		TreeMap<Long, Integer> R = new TreeMap<>();
		for (int i = 0; i < nn; i++) {
			A[i] = scanner.nextLong();
			add(R, A[i]);
		}
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			long ak = A[i];
			remove(R, ak);
			if (ak % kk == 0) {
				sum += (long)count(L, ak / kk) * (long)count(R, ak * kk);
			}
			add(L, ak);
		}
		System.out.println(sum);
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
