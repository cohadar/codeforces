import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		int res = 1;
		int l = 0;
		int r = 0;
		int min = A[0];
		int max = A[0];
		while (r < n - 1) {
			r++;
			if (A[r] != min && A[r] != max) {
				l = r;
				while (l > 0 && ok(A[l-1], min, max)) {

				}
			}
			res = Math.max(res, r - l + 1);
		}
		System.out.println(res);
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

