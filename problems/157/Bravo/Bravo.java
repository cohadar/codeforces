import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		int[] R = scanArray(scanner, n);
		Arrays.sort(R);
		double sum = 0.0;
		double sign = 1.0;
		for (int i = R.length - 1; i >= 0; i--) {
			sum += sign * R[i] * R[i] * Math.PI;
			sign = -sign;
		}
		System.out.println(sum);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

