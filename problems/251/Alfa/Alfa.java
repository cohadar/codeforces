import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static long binom2(int n) {
		return n * (n - 1L) / 2;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int[] A = new int[n];
		NavigableMap<Integer, Integer> S = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			S.put(A[i], i);
		}
		long count = 0;
		for (int ia = 0; ia < A.length; ia++) {
			int a = A[ia];
			int b = a + d;
			int ib = S.floorEntry(b).getValue();
			assert A[ib] - a <= d;
			if (ib > ia) {
				count += binom2(ib - ia);
			}
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
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


