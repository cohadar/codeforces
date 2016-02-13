import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class B {

	public static int highBound(int[] C, int l, int r, int val) {
		while (l <= r) {
			int m = (l + r) >>> 1;
			if (C[m] > val) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		int[] B = scanArray(scanner, m);
		
		int[] C = new int[1 + n];
		for (int cumul = 1, i = 0; i < A.length; i++) {
			cumul += A[i];
			C[i + 1] = cumul;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < B.length; i++) {
			sb.append(highBound(C, 0, C.length - 1, B[i]));
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

