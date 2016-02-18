import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 2 <= n && n <= m : "out of range, n: " + n;
		assert 2 <= m && m <= 50 : "out of range, m: " + m;
		int[] F = scanArray(scanner, m);
		Arrays.sort(F);
		int min = Integer.MAX_VALUE;
		for (int r = n-1; r <= m-1; r++) {
			int l = r - (n-1);
			min = Math.min(min, F[r] - F[l]);
		}
		System.out.println(min);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 4 <= A[i] && A[i] <= 1000 : "out of range, A[i]: " + A[i];
		}
		return A;
	}

}

