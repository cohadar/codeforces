import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	// E, S, W, N
	static int[] DX = new int[] { +1, 00, -1, 00 };
	static int[] DY = new int[] { 00, +1, 00, -1 };

	final int ny;
	final int nx;
	final int pp;
	final int[][] D;
	final Cell[][] C;
	final int[][] T;
	final List<List<Cell>> LL;
	
	public Delta(int ny, int nx, int pp, int[][] D, Cell[][] C, List<List<Cell>> LL) {
		this.ny = ny;
		this.nx = nx;
		this.pp = pp;
		this.D = D;
		this.C = C;
		this.T = new int[ny][nx];
		this.LL = LL;
	}

	public void solveDirect(List<Cell> A, List<Cell> B) {
		for (Cell b : B) {
			int min = D[b.y][b.x];
			for (Cell a : A) {
				min = Math.min(min, D[a.y][a.x] + Math.abs(a.x - b.x) + Math.abs(a.y - b.y));
			}
			D[b.y][b.x] = min;
		}
	}

	public boolean outside(int x, int y) {
		return x < 0 || y < 0 || x >= nx || y >= ny;
	}

	public static int val(int[][] D, Cell c) {
		return D[c.y][c.x];
	}

	public void solveBFS(List<Cell> A, List<Cell> B) {
		for (int y = 0; y < ny; y++) {
			Arrays.fill(T[y], Integer.MAX_VALUE);
		}
		PriorityQueue<Cell> Q = new PriorityQueue<>((a, b) -> Integer.compare(T[a.y][a.x], T[b.y][b.x]));
		for (Cell a : A) {
			T[a.y][a.x] = D[a.y][a.x];
			Q.add(a);
		}
		while (!Q.isEmpty()) {
			Cell c = Q.remove(); 
			for (int i = 0; i < 4; i++) {
				int x = c.x + DX[i];
				int y = c.y + DY[i];
				if (!outside(x, y) && T[y][x] == Integer.MAX_VALUE) {
					T[y][x] = T[c.y][c.x] + 1;
					Q.add(C[y][x]);
				}
			}
		}
		for (Cell b : B) {
			D[b.y][b.x] = T[b.y][b.x];
		}
	}

	public int solve() {
		for (int i = 1; i < pp; i++) {
			List<Cell> A = LL.get(i-1);
			List<Cell> B = LL.get(i);
			if (A.size() * B.size() <= 5 * ny * nx) {
				solveDirect(A, B);	
			} else {
				solveBFS(A, B);	
			}
		}
		Cell c = LL.get(pp-1).get(0);
		return D[c.y][c.x];
	}

	public static Delta load(FastScanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int pp = scanner.nextInt();
		List<List<Cell>> LL = new ArrayList<>(pp);
		for (int i = 0; i < pp; i++) {
			LL.add(new ArrayList<Cell>());
		}
		Cell[][] C = new Cell[ny][nx];
		int[][] D = new int[ny][nx];
		int[][] M = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				M[y][x] = scanner.nextInt() - 1;
				Cell c = new Cell(x, y);
				C[y][x] = c;
				LL.get(M[y][x]).add(c);
				D[y][x] = (M[y][x] == 0) ? x + y : Integer.MAX_VALUE;
			}
		}
		return new Delta(ny, nx, pp, D, C, LL);
	} 

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
	}

}

class Cell {
	final int x;
	final int y;
	Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return String.format("(x=%d, y=%d)", x, y);
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

