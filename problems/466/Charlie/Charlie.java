import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	public static long[] cumul(int[] A) {
		long cumul = 0;
		long[] C = new long[A.length];
		for (int i = 0; i < A.length; i++) {
			cumul += A[i];
			C[i] = cumul;
		}
		return C;
	}

	public static int[] counts(long[] C, long s2) {
		int[] D = new int[C.length];
		int counts = 0;
		for (int i = C.length - 2; i > 0; i--) {
			if (C[i] == s2) {
				counts++;
			}
			D[i] = counts;
		}
		return D;
	}

	public static long solve(long[] C, int[] D, long s) {
		long ret = 0;
		for (int i = 1; i < C.length - 1; i++) {
			if (C[i - 1] == s) {
				ret += D[i];
			}
		}
		return ret;
	}

	public static long solve(int[] A) {
		int n = A.length;
		if (n < 3) {
			return 0;
		}
		long[] C = cumul(A);
		if (C[n - 1] % 3 != 0) {
			return 0;
		}
		long s = C[n - 1] / 3;
		int[] D = counts(C, 2 * s);
		return solve(C, D, s);
	}

	public static long brute(int[] A) {
		int n = A.length;
		long[] C = cumul(A);
		if (n < 3) {
			return 0;
		}		
		if (C[n - 1] % 3 != 0) {
			return 0;
		}
		long s = C[n - 1] / 3;		
		long count = 0;
		for (int a = 1; a < n - 1; a++) {
			for (int b = a; b < n - 1; b++) {
				if (C[a - 1] == s && C[b] == 2*s) {
					count++;
				}
			}
		}	
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 5e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		System.out.println(solve(A));
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}
