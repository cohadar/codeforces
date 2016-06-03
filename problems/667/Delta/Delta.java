import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar z
  */
public class Delta {

	// E, S, W, N
	static int[] DX = new int[] { +1, 00, -1, 00 };
	static int[] DY = new int[] { 00, +1, 00, -1 };

	final int ny;
	final int nx;
	final int pp;
	final int[][] D;
	final int[][] T;
	final List<List<Integer>> LL;
	final PriorityQueue<Integer> Q;
	
	public Delta(int ny, int nx, int pp, int[][] D, List<List<Integer>> LL) {
		this.ny = ny;
		this.nx = nx;
		this.pp = pp;
		this.D = D;
		this.T = new int[ny][nx];
		this.LL = LL;
		this.Q = new PriorityQueue<>(new Comparator<Integer> () {
			public int compare(Integer a, Integer b) {
				return Integer.compare(T[yy(a)][xx(a)], T[yy(b)][xx(b)]);
			}
		});
	}

	public void solveDirect(List<Integer> A, List<Integer> B) {
		for (Integer b : B) {
			int min = D[yy(b)][xx(b)];
			for (Integer a : A) {
				min = Math.min(min, D[yy(a)][xx(a)] + Math.abs(xx(a) - xx(b)) + Math.abs(yy(a) - yy(b)));
			}
			D[yy(b)][xx(b)] = min;
		}
	}

	public boolean outside(int x, int y) {
		return x < 0 || y < 0 || x >= nx || y >= ny;
	}

	public void solveBFS(List<Integer> A, List<Integer> B) {
		for (int y = 0; y < ny; y++) {
			Arrays.fill(T[y], Integer.MAX_VALUE);
		}
		for (Integer a : A) {
			T[yy(a)][xx(a)] = D[yy(a)][xx(a)];
			Q.add(a);
		}
		while (!Q.isEmpty()) {
			int c = Q.remove(); 
			for (int i = 0; i < 4; i++) {
				int x = xx(c) + DX[i];
				int y = yy(c) + DY[i];
				if (!outside(x, y) && T[y][x] == Integer.MAX_VALUE) {
					T[y][x] = T[yy(c)][xx(c)] + 1;
					Q.add(cell(x, y));
				}
			}
		}
		for (int b : B) {
			D[yy(b)][xx(b)] = T[yy(b)][xx(b)];
		}
	}

	static final int xx(int cell) {
		return (cell >> 16) & 0xFFFF;
	}

	static final int yy(int cell) {
		return cell & 0xFFFF;
	}

	static final int cell(int x, int y) {
		return (x << 16) + y;
	}

	public int solve() {
		for (int i = 1; i < pp; i++) {
			List<Integer> A = LL.get(i-1);
			List<Integer> B = LL.get(i);
			if (A.size() * B.size() <= 10 * ny * nx) {
				solveDirect(A, B);	
			} else {
				solveBFS(A, B);	
			}
		}
		int c = LL.get(pp-1).get(0);
		return D[yy(c)][xx(c)];
	}

	public static Delta load(FastScanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int pp = scanner.nextInt();
		List<List<Integer>> LL = new ArrayList<>(pp);
		for (int i = 0; i < pp; i++) {
			LL.add(new ArrayList<Integer>());
		}
		int[][] D = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				int v = scanner.nextInt() - 1;
				int c = cell(x, y);
				assert xx(c) == x;
				assert yy(c) == y;
				LL.get(v).add(c);
				D[y][x] = (v == 0) ? x + y : Integer.MAX_VALUE;
			}
		}
		return new Delta(ny, nx, pp, D, LL);
	} 

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
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
