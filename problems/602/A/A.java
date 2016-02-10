import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static long loadNum(Scanner scanner) {
		int n = scanner.nextInt();
		int bx = scanner.nextInt();
		int[] X = scanArray(scanner, n);
		long x = 0;
		long p = 1;
		for (int i = X.length - 1; i >= 0; i--, p *= bx) {
			x += p * X[i];
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long x = loadNum(scanner);
		long y = loadNum(scanner);
		if (x < y) {
			System.out.println('<');
		} else if (x > y) {
			System.out.println('>');
		} else {
			System.out.println('=');
		}
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}

