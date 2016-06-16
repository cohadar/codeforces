import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nk = scanner.nextInt();
		int nf = scanner.nextInt();
		int[] A = new int[nk];
		Arrays.fill(A, -1);
		assert 2 <= nk && nk <= 3e5 : "out of range, nk: " + nk;
		assert 1 <= nf && nf <= 3e5 : "out of range, nf: " + nf;
		TreeSet<Integer> T = new TreeSet<>();
		for (int i = 0; i < nk; i++) {
			T.add(i);
		}
		for (int i = 0; i < nf; i++) {
			int l = scanner.nextInt() - 1;
			int r = scanner.nextInt() - 1;
			int x = scanner.nextInt() - 1;
			NavigableSet<Integer> S = T.subSet(l, true, r, true);
			Iterator<Integer> it = S.iterator();
			while (it.hasNext()) {
				int y = it.next();
				if (x != y) {
					A[y] = x;
					it.remove();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i] + 1);
			sb.append(' ');
		}
		System.out.println(sb);
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

