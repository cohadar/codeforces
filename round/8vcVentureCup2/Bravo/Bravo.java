import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static boolean right(int[] A, int[] B, int a0, int b0, int n) {
		for (int i = 0; i < n; i++) {
			int a = (a0 + i) % n;
			int b = (b0 + i) % n;
			if (A[a] != B[b]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 2e5 : "out of range, n: " + n;
		int[] A = new int[n-1];
		for (int i = 0, j = 0; i < n; i++, j++) {
			int val = scanner.nextInt();
			if (val == 0) {
				j--;
			} else {
				A[j] = val;
			}
		}
		int[] B = new int[n-1];
		for (int i = 0, j = 0; i < n; i++, j++) {
			int val = scanner.nextInt();
			if (val == 0) {
				j--;
			} else {
				B[j] = val;
			}
		}
		int a0 = 0;
		for (int b0 = 0; b0 < n-1; b0++) {
			if (right(A, B, a0, b0, n-1)) {
				System.out.println("YES");
				return;	
			}
		}
		System.out.println("NO");
	}

}

