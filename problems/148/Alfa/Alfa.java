import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// load
		int[] A = new int[4];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 10 : "out of range, A[i]: " + A[i];
		}
		int d = scanner.nextInt();
		assert 1 <= d && d <= 1e5 : "out of range, d: " + d;
		// special
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				System.out.println(d);
				return;
			}
		}
		// damage
		boolean[] D = new boolean[1 + d];
		for (int i = 0; i < A.length; i++) {
			for (int p = A[i]; p <= d; p += A[i]) {
				D[p] = true;
			}
		}
		// count
		int count = 0;
		for (int i = 1; i < D.length; i++) {
			if (D[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}

