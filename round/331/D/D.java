import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class D {

	final int h;
	final float pl;
	final float pr;
	final int[] X;
	final float ql = 0.5f;
	final float qr = 0.5f;
	final float[][][] mem;

	public D(int h, float p, int[] X) {
		this.h = h;
		this.pl = p;
		this.pr = 1.0f - p;
		this.X = X;
		this.mem = new float[X.length][X.length][4];
	}

	float ll(int l, int r, int dl, int dr) {
		if (l == r) {
			return dl;
		} 		
		int ndl = Math.min(X[l + 1] - X[l], h);
		return dl + solve(l + 1, r, ndl, dr); 
	}

	float rr(int l, int r, int dl, int dr) {
		if (l == r) {
			return dr;
		} 
		int ndr = Math.min(X[r] - X[r - 1], h);
		return dr + solve(l, r - 1, dl, ndr);
	}

	float lr(int l, int r, int dl, int dr) {
		if (l == r) {
			return dr;
		} 		
		if (X[l + 1] - X[l] >= h) {
			int ndl = Math.min(X[l + 1] - (X[l] + h), h);
			return h + solve(l + 1, r, ndl, dr);
		}
		return X[l + 1] - X[l] + lr(l + 1, r, 0, dr);
	}

	float rl(int l, int r, int dl, int dr) {
		if (l == r) {
			return dl;
		} 		
		if (X[r] - X[r - 1] >= h) {
			int ndr = Math.min(h, X[r] - h - X[r - 1]);
			return h + solve(l, r - 1, dl, ndr);
		}
		return X[r] - X[r - 1] + rl(l, r - 1, dl, 0);
	}	

	public float solve(int l, int r, int dl, int dr) {
		if (l == r) {
			return pl * dl + pr * dr;
		}
		int i = index(dl, dr);
		if (mem[l][r][i] != 0) {
			return mem[l][r][i];
		}
		float ret = 0.0f;
		ret += ql * pl * ll(l, r, dl, dr);
		ret += qr * pr * rr(l, r, dl, dr);
		ret += ql * pr * lr(l, r, dl, dr);
		ret += qr * pl * rl(l, r, dl, dr);
		mem[l][r][i] = ret;
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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		float p = scanner.nextFloat();
		int[] X = scanArray(scanner, n);
		Arrays.sort(X);
		D o = new D(h, p, X);
		System.out.println(o.solve(0, n - 1, h, h));
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

