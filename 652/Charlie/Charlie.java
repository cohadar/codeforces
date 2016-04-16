import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final long n;
	final int[] P;
	final Integer[] H;
	
	public Charlie(int n, int[] P, Integer[] H) {
		this.n = n;
		this.P = P;
		this.H = H;
	}

	public static long count(int ia, int ib, int n) {
		return ia;
	}

	public long solve() {
		long count = 0;
		long prev = 0;
		for (int ib = 0; ib < n; ib++) {
			Integer ia = H[ib];
			if (ia == null) {
				count += prev;
			} else {
				assert ia < ib;
				prev = ia + 1;
				count += prev;
			}
		}
		return n * (n + 1) / 2 - count;
	}

	public static void updateH(Integer[] H, int ia, int ib) {
		if (H[ib] == null) {
			H[ib] = ia;
		} else if (H[ib] > ia) {
			H[ib] = ia;
		}
	}

	public static Charlie load(Scanner scanner) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 3e5 : "out of range, n: " + n;
		assert 1 <= m && m <= 3e5 : "out of range, m: " + m;
		int[] P = scanArray(scanner, n);
		int[] I = new int[n];
		for (int i = 0; i < n; i++) {
			assert I[P[i]] == 0;
			I[P[i]] = i;
		}
		Integer[] H = new Integer[n];
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			updateH(H, Math.min(I[a], I[b]), Math.max(I[a], I[b]));
		}
		return new Charlie(n, P, H);
	} 

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt() - 1;
			assert 0 <= A[i] && A[i] < n : "out of range, A[i]: " + A[i];
		}
		return A;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Charlie o = Charlie.load(scanner);
		System.out.println(o.solve());
	}

}
