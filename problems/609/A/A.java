import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		int[] A = scanArray(scanner, n);
		Arrays.sort(A);
		int count = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			m -= A[i];
			count++;
			if (m <= 0) {
				break;
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

