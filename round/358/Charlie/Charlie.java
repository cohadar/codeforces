import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final int n;
	final int[] A;
	final List<List<Edge>> G;
	
	public Charlie(int n, int[] A, List<List<Edge>> G) {
		this.n = n;
		this.A = A;
		this.G = G;
	}

	public int solve() {
		boolean[] V = new boolean[n];
		long[] D = new long[n];
		V[0] = true;
		Deque<Integer> Q = new ArrayDeque<>();
		Q.add(0);
		int added = 1;
		while (!Q.isEmpty()) {
			int a = Q.remove();
			for (Edge e : G.get(a)) {
				if (!V[e.b]) {
					V[e.b] = true;
					D[e.b] = Math.max(D[a] + e.w, e.w);
					if (D[e.b] <= A[e.b]) {
						Q.add(e.b);
						added++;
					}
				}
			}
		}
		return n - added;
	}

	public static Charlie load(FastScanner scanner) {
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();			
		}
		List<List<Edge>> G = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			G.add(new ArrayList<Edge>());
		}
		for (int a = 0; a < n - 1; a++) {
			int b = scanner.nextInt() - 1;
			int w = scanner.nextInt();
			G.get(a + 1).add(new Edge(b, w));
			G.get(b).add(new Edge(a + 1, w));
		}
		return new Charlie(n, A, G);
	} 

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		Charlie o = Charlie.load(scanner);
		System.out.println(o.solve());
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

class Edge {
	final int b;
	final int w;
	Edge(int b, int w) {
		this.b = b;
		this.w = w;
	}
	public String toString() {
		return String.format("(b=%d, w=%d)", b, w);
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

			