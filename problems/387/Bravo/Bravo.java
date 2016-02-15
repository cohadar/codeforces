import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 3000 : "out of range, n: " + n;
		int m = scanner.nextInt();
		assert 1 <= m && m <= 3000 : "out of range, m: " + m;
		// arrays are sorted
		int[] A = scanArray(scanner, n);
		int[] B = scanArray(scanner, m);
		int crossed = 0;
		int a = A.length - 1;
		int b = B.length - 1;
		while (a >= 0 && b >= 0) {
			if (A[a] <= B[b]) {
				a--;
				b--;
				crossed++;
			} else {
				a--;
			}
		}
		System.out.println(A.length - crossed);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

