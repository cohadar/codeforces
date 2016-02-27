import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		int[] A = scanArray(scanner, n);
		int[] B = scanArray(scanner, m);
		Set<Integer> S = new HashSet<>();
		int[] C = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			S.add(A[i]);
			C[i] = S.size();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < B.length; i++) {
			sb.append(C[B[i] - 1]);
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

