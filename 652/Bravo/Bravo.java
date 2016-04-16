import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
		}
		Arrays.sort(A);
		if (n < 3) {
			System.out.println(join(A, " "));
			return;
		} 
		int[] B = new int[n];
		B[0] = A[0];
		B[1] = A[2];
		B[2] = A[1];
		for (int i = 3; i < A.length; i++) {
			if (i % 2 == 0) {
				B[i] = A[i - 1];	
			} else {
				B[i] = A[Math.min(n - 1, i + 1)];
			}
		}
		System.out.println(join(B, " "));
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

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

