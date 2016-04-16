import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final int nn;
	final int kk;
	final int[] A;
	final int[][] R;
	
	public Charlie(int n, int k, int[] A) {
		this.nn = n;
		this.kk = k;
		this.A = A;
		this.R = new int[2][n];
	}

	public static int m2(int k) {
		return k % 2;
	}

	public int solve() {		
		int max = 0;
		int imax = -1;

		R[0][0] = A[0];
		for (int n = 1; n < nn; n++) {
			R[0][n] = (A[n] == 0) ? 0 : R[0][n-1] + 1;
			max = Math.max(max, R[0][n]);
		}		
		for (int k = 1; k <= kk; k++) {
			R[m2(k)][0] = 1;
			for (int n = 1; n < nn; n++) {
				int temp = R[m2(k-(1 - A[n]))][n-1] + 1;
				if (R[m2(k)][n] < temp) {
					R[m2(k)][n] = temp;
					if (max < R[m2(k)][n]) {
						max = R[m2(k)][n];
						imax = n;						
					}
				}
			}
		}
		if (imax != -1) {
			for (int i = 0; i < max; i++) {
				A[imax - i] = 1;
			}			
		}
		return max;
	}

	public static Charlie load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		assert 1 <= n && n <= 3e5 : "out of range, n: " + n;
		assert 0 <= k && k <= n : "out of range, k: " + k;
		int[] A = scanArray(scanner, n, 0, 1);
		return new Charlie(n, k, A);
	} 

	static int[] scanArray(Scanner scanner, int n, int min, int max) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert min <= A[i] && A[i] <= max : "out of range, A[i]: " + A[i];
		}
		return A;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Charlie o = Charlie.load(scanner);
		System.out.println(o.solve());
		System.out.println(join(o.A, " "));
	}

	static String join(int[] A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int a : A) {
			sb.append(a);
			sb.append(delimiter);
		}
		if (sb.length() >= delimiter.length()) {
			sb.setLength(sb.length() - delimiter.length());
		}			
		return sb.toString();
	}

}
