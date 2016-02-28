import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 15e4 : "out of range, n: " + n;
		int k = scanner.nextInt();
		assert 1 <= k && k <= n : "out of range, k: " + k;
		int[] A = scanArray(scanner, n);
		int imin = 0;
		int smin = 0;
		for (int i = 0; i < k; i++) {
			smin += A[i];
		}
		int sum = smin;
		for (int i = k; i < A.length; i++) {
			sum += A[i];
			sum -= A[i - k];
			if (smin > sum) {
				smin = sum;
				imin = i - k + 1;
			}
		}
		System.out.println(1 + imin);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 100 : "out of range, A[i]: " + A[i];
		}
		return A;
	}
}

