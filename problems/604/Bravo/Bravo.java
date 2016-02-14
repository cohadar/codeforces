import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	final int n;
	final int k;
	final int[] S;
	
	public Bravo(int n, int k, int[] S) {
		this.n = n;
		this.k = k;
		this.S = S;
	}

	public boolean canFit(int s) {
		if (s < S[n - 1]) {
			return false;
		}
		if (k >= n) {
			return true;
		}
		int fits = n - k;
		for (int i = 0; i < fits; i++) {
			int j = 2 * fits - i - 1;
			if (S[i] + S[j] > s) {
				return false;
			}
		}
		return true;
	}

	public int lowerBound(int l, int r) {
		while (l <= r) {
			int m = (l + r) >>> 1;
			if (canFit(m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	public int solve() {
		return lowerBound(S[n - 1], 2 * S[n - 1]);
	}

	public static Bravo load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		assert n <= 2 * k && 2 * k <= 1e5 : "out of range, 2 * k: " + 2 * k;
		int[] S = scanArray(scanner, n); // input is sorted
		return new Bravo(n, k, S);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println(o.solve());
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}
