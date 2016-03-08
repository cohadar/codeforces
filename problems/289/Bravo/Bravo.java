import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= m && m <= 100 : "out of range, m: " + m;
		int d = scanner.nextInt();
		assert 1 <= d && d <= 1e4 : "out of range, d: " + d;
		int[] A = scanArray(scanner, n * m);		
		int r = A[0] % d;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % d != r) {
				System.out.println("-1");
				return;
			} else {
				A[i] /= d;
			}
		}
		int res = 0;
		Arrays.sort(A);
		int j = A[A.length / 2];
		for (int i = 0; i < A.length; i++) {
			res += Math.abs(A[i] - j);
		}
		System.out.println(res);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e4 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

