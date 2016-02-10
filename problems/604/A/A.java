import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] X = new int[] { 500, 1000, 1500, 2000, 2500 };
		int[] M = scanArray(scanner, 5);
		int[] W = scanArray(scanner, 5);
		int sh = scanner.nextInt();
		int uh = scanner.nextInt();
		double sum = 0.0;
		for (int i = 0; i < 5; i++) {
			sum += Math.max(0.3 * X[i], (1.0 - M[i] / 250.0) * X[i] - 50.0 * W[i]);
		}
		sum += sh * 100.0;
		sum -= uh * 50.0;
		System.out.println((int)Math.round(sum));
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

