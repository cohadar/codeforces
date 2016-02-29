import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Echo {

	final int d;
	final int n;
	final int[] X;
	final int[] P;
	final SegmentTree T;
	
	public Echo(int d, int n, int[] X, int[] P) {
		this.d = d;
		this.n = n;
		this.X = X;
		this.P = P;
		this.T = new SegmentTree(new MinOP(), P);
		debug(d, n);
		debug(X);
		debug(P);
	}
	
	public long solve() {
		long total = 0;
		int tank = n;
		
		return -1;
	}

	static class Station implements Comparable<Station> {
		final int x;
		final int p;
		Station(int x, int p) {
			this.x = x;
			this.p = p;
		}
		public int compareTo(Station that) {
			if (this.x == that.x) {
				return Integer.compare(this.p, that.p);
			} else {
				return Integer.compare(this.x, that.x);
			}
		}
		public String toString() {
			return String.format("(x=%d, p=%d)", x, p);
		}	
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= d && d <= 1e9 : "out of range, d: " + d;
		assert 1 <= n && n <= 1e9 : "out of range, n: " + n;
		assert 1 <= m && m <= 2e5 : "out of range, m: " + m;
		Station[] S = new Station[m + 1];
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			int p = scanner.nextInt();
			S[i] = new Station(x, p);
		}
		S[m] = new Station(d, 0);
		Arrays.sort(S);
		int[] X = new int[m+1];
		int[] P = new int[m+1];
		for (int i = 0; i < m+1; i++) {
			X[i] = S[i].x;
			P[i] = S[i].p;
		}
		Echo e = new Echo(d, n, X, P);
		System.out.println(e.solve());
	}


	static boolean DEBUG = true;

	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

class MinOP implements SegmentTree.OP {
	@Override
	public int zero() {
		return Integer.MAX_VALUE;
	}
	@Override
	public int binary(int va, int vb) {
		return Integer.min(va, vb);
	}
}

/***/
class SegmentTree {

	public static interface OP {
		public int zero();
		public int binary(int va, int vb);
	}

	final OP op;
	final int n;
	final int in;
	final int[] T;

	public SegmentTree(OP op, int n) {
		this.op = op;
		this.n = n;
		this.in = indexLength(n);
		this.T = new int[in + n];
		fill(null);
	}	
	
	public SegmentTree(OP op, int[] A) {
		this.op = op;
		this.n = A.length;
		this.in = indexLength(n);
		this.T = new int[in + n];
		fill(A);
	}

	private static int left(int p) {
		return 2 * p;
	}

	private static int right(int p) {
		return 2 * p + 1;
	}

	private static int parent(int p) {
		return p / 2;
	}	

	private int indexLength(int n) {
		int height = (int) Math.ceil(Math.log(n) / Math.log(2));
		return 1 << height;
	}

	private void fill(int[] A) {
		Arrays.fill(T, op.zero());
		if (A != null) {
			for (int i = 0; i < A.length; i++) {
				T[in + i] = A[i];
			}
		}
		for (int p = in - 1; p > 0; p--) {
			T[p] = op.binary(t(left(p)), t(right(p)));
		}
	}

	private int t(int p) {
		if (p < in + n) {
			return T[p];
		}
		return op.zero();
	}

	// warning: assuming OP will now overflow integer
	public int queryRange(int l, int r) {
		assert l <= r;
		assert 0 <= l;
		assert r < in;
		int resl = op.zero();
		int resr = op.zero();
		for (l += in, r += in; l <= r; l = parent(l), r = parent(r)) {
			if (l % 2 == 1) resl = op.binary(resl, T[l++]);
			if (r % 2 == 0) resr = op.binary(T[r--], resr);
		}
		return op.binary(resl, resr);		
	}

	public void updateValue(int i, int val) {
		assert 0 <= i;
		assert i < n;
		int p = in + i;
		while (p > 0) {
			T[p] = val;
			p = parent(p);
			val = op.binary(T[left(p)], T[right(p)]);
		}
	}

}
