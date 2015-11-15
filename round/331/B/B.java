import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class B {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] B = scanArray(scanner, n);
		long steps = Math.abs(B[0]);
		long base = B[0];
		for (int i = 1; i < B.length; i++) {
			steps += Math.abs(B[i - 1] - B[i]);
		}
		System.out.println(steps);
	}

	static long[] scanArray(Scanner scanner, int n) {
		long[] A = new long[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextLong();
		}
		return A;
	}

}

