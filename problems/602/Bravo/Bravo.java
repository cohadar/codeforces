import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	final int n;
	final int[] A;
	int l;
	int r;
	int min;
	int max;

	public Bravo(int n, int[] A) {
		this.n = n;
		this.A = A;
		this.min = A[0];
		this.max = A[0];
	}

	public void goback() {
		while (l > 0) {
			if (A[l - 1] == min || A[l - 1] == max) {
				l--;
			} else if (min == max) {
				if (Math.abs(A[l - 1] - min) <= 1) {
					min = Math.min(min, A[l - 1]);
					max = Math.max(max, A[l - 1]);
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}

	public int solve() {
		int res = 1;
		while (r < n - 1) {
			r++;
			if (A[r] != min && A[r] != max) {
				l = r;
				min = A[r];
				max = A[r];
				goback();
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		Bravo o = new Bravo(n, A);
		System.out.println(o.solve());
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e5 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

