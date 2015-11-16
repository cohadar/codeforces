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

	int index(boolean dl, boolean dr) {
		if (dl) {
			if (dr) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (dr) {
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

	int dist(int a, int b) {
		return Math.min(h, X[b] - X[a]);
	}

	int ll(int l, int r, boolean dl, boolean dr, int prev) {
		if (prev == l - 1 && dl == true) {
			return Math.min(h, X[l] - (X[l - 1] + h));
		}
		return Math.min(h, X[l] - X[l - 1]);
	}

	int lr(int l, int r, boolean dl, boolean dr, int prev) {
		return Math.min(h, X[l + 1] - X[l]);
	}

	int rl(int l, int r, boolean dl, boolean dr, int prev) {
		return Math.min(h, X[r] - X[r - 1]);
	}

	int rr(int l, int r, boolean dl, boolean dr, int prev) {
		if (prev == r + 1 && dr == false) {
			return Math.min(h, (X[r + 1] - h) - X[r]);
		}
		return Math.min(h, X[r + 1] - X[r]);
	}

	public double solve(int l, int r, boolean dl, boolean dr, int prev) {
		if (l > r) {
			return 0;
		}
		int i = index(dl, dr); 
		int j = triangl(l, r);
		if (mem[i][j] != 0) {
			return mem[i][j];
		}		
		if (dl == true && X[l] - X[l - 1] < h) {
			double ret = dist(l, l + 1) + solve(l + 1, r, true, dr, l);
			mem[i][j] = ret;
			return ret;
		}
		if (dr == false && X[r + 1] - X[r] < h) {
			double ret = dist(r - 1, r) + solve(l, r - 1, dl, false, r);
			mem[i][j] = ret;
			return ret;
		}
		double ret = 0.0f;
		ret += ql * pl * (ll(l, r, dl, dr, prev) + solve(l + 1, r, false, dr, l));
		ret += ql * pr * (lr(l, r, dl, dr, prev) + solve(l + 1, r, true, dr, l));
		ret += qr * pl * (rl(l, r, dl, dr, prev) + solve(l, r - 1, dl, false, r));
		ret += qr * pr * (rr(l, r, dl, dr, prev) + solve(l, r - 1, dl, true, r));
		mem[i][j] = ret;
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		double p = scanner.nextDouble();
		int[] X = scanArray(scanner, n);
		D o = new D(h, p, X);
		System.out.println(o.solve(1, n, false, true, 0));
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

}

