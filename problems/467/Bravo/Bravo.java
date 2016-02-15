import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 20 : "out of range, n: " + n;
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1000 : "out of range, m: " + m;
		int k = scanner.nextInt();
		assert 1 <= k && k <= n : "out of range, k: " + k;
		int[] X = scanArray(scanner, m);
		int fedor = scanner.nextInt();
		int count = 0;
		for (int x : X) {
			if (Integer.bitCount(x ^ fedor) <= k) {
				count++;
			}
		}
		System.out.println(count);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

