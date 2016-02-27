import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		int m = scanner.nextInt();
		assert 1 <= m && m <= 100 : "out of range, m: " + m;
		int[] B = scanArray(scanner, m);
		Arrays.sort(A);
		Arrays.sort(B);
		int a = 0;
		int b = 0;
		int count = 0;
		while (a < n && b < m) {
			if (Math.abs(A[a] - B[b]) <= 1) {
				count++;
				a++;
				b++;
			} else if (A[a] > B[b]) {
				b++;
			} else {
				a++;
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

