import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	static final double INF = 1e100;

	final int nn;
	final int[] X;
	final int[] Y;
	final double[] D;
	final double total;
	
	public Charlie(int nn, int[] X, int[] Y) {
		this.nn = nn;
		this.X = X;
		this.Y = Y;
		this.D = new double[nn];
		double temp = 0.0;
		for (int i = 0; i < nn; i++) {
			D[i] = Math.hypot(X[i], Y[i]);
			temp += D[i];
		}
		total = temp * 2;
	}

	public int iminDist(int x, int y, int avoid) {
		int imin = -1;
		double min = INF;
		for (int i = 0; i < nn; i++) {
			if (i == avoid) {
				continue;
			}
			double dd = save(i, x, y);
			if (min > dd) {
				min = dd;
				imin = i;
			}
		}
		assert imin != -1;
		return imin;
	}

	public double save(int imin, int x, int y) {
		return Math.hypot(X[imin] - x, Y[imin] - y) - Math.hypot(X[imin], Y[imin]);
	}

	public double only(int x, int y) {
		int imin = iminDist(x, y, -1);
		return total + save(imin, x, y);
	}

	public double both(int ax, int ay, int bx, int by) {
		if (nn == 1) {
			return INF;
		}
		int amin = iminDist(ax, ay, -1);
		int bmin = iminDist(bx, by, amin);
		return total + save(amin, ax, ay) + save(bmin, bx, by);
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int ax = scanner.nextInt();
		int ay = scanner.nextInt();
		int bx = scanner.nextInt();
		int by = scanner.nextInt();
		int tx = scanner.nextInt();
		int ty = scanner.nextInt();
		ax -= tx;
		ay -= ty;
		bx -= tx;
		by -= ty;
		int nn = scanner.nextInt();
		int[] X = new int[nn];
		int[] Y = new int[nn];
		for (int i = 0; i < nn; i++) {
			X[i] = scanner.nextInt() - tx;
			Y[i] = scanner.nextInt() - ty;
		}
		Charlie o = new Charlie(nn, X, Y);
		double[] R = new double[4];
		R[0] = o.only(ax, ay);
		R[1] = o.only(bx, by);
		R[2] = o.both(ax, ay, bx, by);
		R[3] = o.both(bx, by, ax, ay);
		debug(R);
		System.out.printf("%.10f\n", min(R));
	}

	public static double min(double[] A) {
		double min = A[0];
		for (int i = 1; i < A.length; i++) {
			if (min > A[i]) {
				min = A[i];
			}
		}
		return min;
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
