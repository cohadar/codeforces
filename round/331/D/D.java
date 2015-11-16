import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class D {

	private final int FL = 0;
	private final int FR = 1;

	final int h;
	final double pl;
	final double pr;
	final int[] X;
	final double ql = 0.5f;
	final double qr = 0.5f;
	final double[][] mem;
	final int[][] zez;
	int count;

	public D(int h, double p, int[] X) {
		this.h = h;
		this.pl = p;
		this.pr = 1.0f - p;
		this.X = X;
		this.mem = new double[4][X.length * (X.length + 1) / 2];
		this.zez = new int[2][X.length];
		Arrays.sort(this.X);		
		// FL
		for (int i = 1; i < X.length; i++) {
			if (X[i] - X[i - 1] < h) {
				zez[FL][i] = zez[FL][i - 1] + 1;
			}
		}
		// FR
		for (int i = X.length - 2; i >= 0; i--) {
			if (X[i + 1] - X[i] < h) {
				zez[FR][i] = zez[FR][i + 1] + 1;
			}
		}
	}

	double ll(int l, int r, int dl, int dr) {
		assert l <= r;
		count++;
		double ret;
		if (l == r) {
			return dl;
		}
		int ndl = Math.min(X[l + 1] - X[l], h);
		return dl + solve(l + 1, r, ndl, dr);
	}

	double rr(int l, int r, int dl, int dr) {
		assert l <= r;
		count++;
		double ret;
		if (l == r) {
			return dr;
		}
		int ndr = Math.min(X[r] - X[r - 1], h);
		return dr + solve(l, r - 1, dl, ndr);
	}

	int ndl(int l) {
		return Math.min(X[l + 1] - (X[l] + h), h);
	}

	int ndr(int r) {
		return Math.min(X[r] - (X[r - 1] + h), h);
	}

	double lr(int l, int r, int dr) {
		assert l <= r;
		count++;
		if (l == r) {
			return dr;
		} 
		int delta = zez[FR][l];
		return (X[l + delta] - X[l]) + h + solve(l + 1 + delta, r, ndl(l + delta), dr);			
	}

	double rl(int l, int r, int dl) {
		assert l <= r;
		count++;
		if (l == r) {
			return dl;
		}
		int delta = zez[FL][r];
		return (X[r] - X[r - delta]) + h + solve(l, r - 1 - delta, dl, ndr(r - delta));
	}

	int index(int dl, int dr) {
		assert dl <= h;
		assert dr <= h;
		if (dl < h) {
			if (dr < h) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (dr < h) {
				return 2;
			} else {
				return 3;
			}
		}
	}

	int triangl(int l, int r) {
		assert l <= r;
		return r * (r + 1) / 2 + l;
	}

	public double solve(int l, int r, int dl, int dr) {
		if (l > r) {
			return 0;
		}
		int i = index(dl, dr); 
		int j = triangl(l, r);
		if (mem[i][j] != 0) {
			return mem[i][j];
		}		
		double ret = 0.0f;
		ret += ql * pl * ll(l, r, dl, dr);
		ret += qr * pr * rr(l, r, dl, dr);
		ret += ql * pr * lr(l, r, dr);
		ret += qr * pl * rl(l, r, dl);
		mem[i][j] = ret;
		debug(l, r, dl, dr, "->", ret);
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		double p = scanner.nextDouble();
		int[] X = scanArray(scanner, n);
		D o = new D(h, p, X);
		System.out.println(o.solve(1, n, h, h));
		debug(o.count);
	}

	static final int INF = 1000000007;

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n + 2];
		A[0] = INF;
		A[1] = -INF;
		for (int i = 0; i < n; i++) {
			A[2 + i] = scanner.nextInt();
		}
		return A;
	}

	static boolean DEBUG = true;

	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

