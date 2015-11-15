import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class D {

	static final int LL = 0;
	static final int RR = 1;
	static final int LR = 2;
	static final int RL = 3;

	final int h;
	final float pl;
	final float pr;
	final int[] X;
	final float ql = 0.5f;
	final float qr = 0.5f;
	final float[][][] mem;
	int count;

	public D(int h, float p, int[] X) {
		this.h = h;
		this.pl = p;
		this.pr = 1.0f - p;
		this.X = X;
		this.mem = new float[12][X.length][X.length];
	}

	float ll(int l, int r, int dl, int dr) {
		int i = index(dl, dr); // 0123
		if (mem[i][l][r] != 0) {
			return mem[i][l][r];
		}
		count++;
		float ret;
		if (l == r) {
			ret = dl;
		} else {
			int ndl = Math.min(X[l + 1] - X[l], h);
			ret = dl + solve(l + 1, r, ndl, dr);
		}
		mem[i][l][r] = ret;
		return ret;
	}

	float rr(int l, int r, int dl, int dr) {
		int i = 4 + index(dl, dr); // 4567
		if (mem[i][l][r] != 0) {
			return mem[i][l][r];
		}
		count++;
		float ret;
		if (l == r) {
			ret = dr;
		} else {
			int ndr = Math.min(X[r] - X[r - 1], h);
			ret = dr + solve(l, r - 1, dl, ndr);
		}
		mem[i][l][r] = ret;
		return ret;
	}

	float lr(int l, int r, int dr) {
		int i = (dr < h) ? 8 : 9; // 89
		if (mem[i][l][r] != 0) {
			return mem[i][l][r];
		}
		count++;
		float ret;
		if (l == r) {
			ret = dr;
		} else if (X[l + 1] - X[l] >= h) {
			int ndl = Math.min(X[l + 1] - (X[l] + h), h);
			ret = h + solve(l + 1, r, ndl, dr);
		} else {
			ret = X[l + 1] - X[l] + lr(l + 1, r, dr);
		}
		mem[i][l][r] = ret;
		return ret;
	}

	float rl(int l, int r, int dl) {
		int i = (dl < h) ? 10 : 11; // AB
		if (mem[i][l][r] != 0) {
			return mem[i][l][r];
		}
		count++;
		float ret;
		if (l == r) {
			ret = dl;
		} else if (X[r] - X[r - 1] >= h) {
			int ndr = Math.min(h, X[r] - h - X[r - 1]);
			ret = h + solve(l, r - 1, dl, ndr);
		} else {
			ret = X[r] - X[r - 1] + rl(l, r - 1, dl);
		}
		mem[i][l][r] = ret;
		return ret;
	}

	int index(int dl, int dr) {
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

	public float solve(int l, int r, int dl, int dr) {
		if (l == r) {
			return pl * dl + pr * dr;
		}
		float ret = 0.0f;
		ret += ql * pl * ll(l, r, dl, dr);
		ret += qr * pr * rr(l, r, dl, dr);
		ret += ql * pr * lr(l, r, dr);
		ret += qr * pl * rl(l, r, dl);
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		float p = scanner.nextFloat();
		int[] X = scanArray(scanner, n);
		Arrays.sort(X);
		D o = new D(h, p, X);
		System.out.println(o.solve(0, n - 1, h, h));
		System.err.println(o.count);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

