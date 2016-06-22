import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static long solve(long l, long r) {
		int bc = Long.bitCount(l);
		long res = l;
		long x = l;
		for (int i = 0; i < 64; i++) {
			x |= (1L << i);
			if (l <= x && x <= r) {
				if (bc <= Long.bitCount(x)) {
					bc = Long.bitCount(x);
					res = x;
				}
			} else {
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			long l = scanner.nextLong();
			long r = scanner.nextLong();			
			sb.append(solve(l, r));
			sb.append('\n');
		}
		System.out.print(sb);
	}

	
}

class FastScanner {
	private final BufferedReader in;
	private final StringBuilder sb;
	private StringTokenizer strtok;
	public FastScanner(InputStream is) {
		this.in = new BufferedReader(new InputStreamReader(is));
		this.sb = new StringBuilder();
		this.strtok = null;
	}
	public String next() {
		try {
			if (strtok == null || strtok.hasMoreTokens() == false) {
				strtok = new StringTokenizer(in.readLine());
			}
			return strtok.nextToken();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public long nextLong() {
		return Long.parseLong(next());
	}
	public String nextLine() {
		try {
			if (strtok == null) {
				return in.readLine();
			} else {
				String ret = (strtok.hasMoreTokens()) ? strtok.nextToken("\n") : "";
				strtok = null;
				return ret;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
