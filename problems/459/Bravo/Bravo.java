import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 2e5 : "out of range, n: " + n;
		int[] B = scanArray(scanner, n);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		long nmin = 0;
		long nmax = 0;
		for (int b : B) {
			if (min == b) {
				nmin++;
			}
			if (max == b) {
				nmax++;
			}
			if (min > b) {
				min = b;
				nmin = 1;
			}
			if (max < b) {
				max = b;
				nmax = 1;
			}
		}
		if (max == min) {
			System.out.println("0 " + (nmax * (nmax - 1) / 2));
		} else {
			System.out.printf("%d %d", max - min, (long)nmax * (long)nmin);
		}
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

