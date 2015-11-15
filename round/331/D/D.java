import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class D {

	final int h;
	final double pl;
	final double pr;
	final int[] X;
	final double ql = 0.5;
	final double qr = 0.5;

	public D(int h, double p, int[] X) {
		this.h = h;
		this.pl = p;
		this.pr = 1.0 - p;
		this.X = X;
	}

	double ll(int l, int r, int dl, int dr) {
		if (l == r) {
			return dl;
		} 		
		int ndl = Math.min(X[l + 1] - X[l], h);
		return dl + solve(l + 1, r, ndl, dr); 
	}

	double rr(int l, int r, int dl, int dr) {
		if (l == r) {
			return dr;
		} 
		int ndr = Math.min(X[r] - X[r - 1], h);
		return dr + solve(l, r - 1, dl, ndr);
	}

	double lr(int l, int r, int dl, int dr) {
		if (l == r) {
			return dr;
		} 		
		if (X[l + 1] - X[l] >= h) {
			int ndl = Math.min(X[l + 1] - (X[l] + h), h);
			return h + solve(l + 1, r, ndl, dr);
		}
		return X[l + 1] - X[l] + lr(l + 1, r, 0, dr);
	}

	double rl(int l, int r, int dl, int dr) {
		if (l == r) {
			return dl;
		} 		
		if (X[r] - X[r - 1] >= h) {
			int ndr = Math.min(h, X[r] - h - X[r - 1]);
			return h + solve(l, r - 1, dl, ndr);
		}
		return X[r] - X[r - 1] + rl(l, r - 1, dl, 0);
	}	

	public double solve(int l, int r, int dl, int dr) {
		if (l == r) {
			return pl * dl + pr * dr;
		}
		double ret = 0.0;
		ret += ql * pl * ll(l, r, dl, dr);
		ret += qr * pr * rr(l, r, dl, dr);
		ret += ql * pr * lr(l, r, dl, dr);
		ret += qr * pl * rl(l, r, dl, dr);
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		double p = scanner.nextDouble();
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

