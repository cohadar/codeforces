import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	final int n;
	final int m;
	final int[] A;
	final boolean[][] E;
	final boolean[][] F;
	
	public Bravo(int n, int m, int[] A) {
		this.n = n;
		this.m = m;
		this.A = A;
		this.E = new boolean[2][m];
		this.F = new boolean[2][m];
	}

	public int modm(long a, long b) {
		return (int)((a + b) % m);
	}

	public boolean ee(int index, int acc) {
		if (index < 0) {
			return false;
		}
		return E[index%2][acc];
	}

	public boolean ff(int index, int acc) {
		if (index < 0) {
			return acc % m == 0;
		}
		return F[index%2][acc];
	}

	public boolean solve() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				F[y%2][x] = ff(y-1, modm(x, A[y])) || ff(y-1, x);
				E[y%2][x] = ff(y-1, modm(x, A[y])) || ee(y-1, x);	
			}
		}
		return E[(n-1)%2][0];
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
		System.out.println((o.solve()) ? "YES" : "NO");
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
