import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	final int n;
	final int m;
	final int[] A;
	
	public Bravo(int n, int m, int[] A) {
		this.n = n;
		this.m = m;
		this.A = A;
	}

	public boolean solve(int index, int acc, boolean nonEmpty) {
		if (index >= n) {
			return nonEmpty && acc % m == 0;
		} else {
			return solve(index + 1, acc + A[index], true) || solve(index + 1, acc, nonEmpty);
		}
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 1e6 : "out of range, n: " + n;
		assert 2 <= m && m <= 1e3 : "out of range, m: " + m;
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
			assert 0 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
			if (A[i] == 0) {
				System.out.println("YES");
				return;
			}
		}
		Bravo o = new Bravo(n, m, A);
		System.out.println((o.solve(0, 0, false)) ? "YES" : "NO");
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
