import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int target(char[] A) {
		int target = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == '+') {
				target++;
			} else {
				target--;
			}
		}
		return target;
	}

	public static int[] func(int[] X, char b) {
		int[] R = new int[21];
		if (b == '+') {
			for (int i = 0; i < X.length - 1; i++) {
				R[i + 1] += X[i];
			}
		} else if (b == '-') {
			for (int i = 1; i < X.length; i++) {
				R[i - 1] += X[i];
			}
		} else {
			for (int i = 1; i < X.length - 1; i++) {
				R[i - 1] += X[i];
				R[i + 1] += X[i];
			}
		}
		return R;
	}

	public static int[] solve(char[] B) {
		int[][] X = new int[B.length + 1][21];
		X[0][0 + 10] = 1;
		for (int i = 0; i < B.length; i++) {
			X[i + 1] = func(X[i], B[i]);
		}
		return X[B.length];
	}

	public static int sum(int[] A) {
		int s = 0;
		for (int i = 0; i < A.length; i++) {
			s += A[i];
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] A = scanner.nextLine().toCharArray();
		char[] B = scanner.nextLine().toCharArray();
		assert A.length == B.length : "A.length=" + A.length + ", B.length=" + B.length;
		assert 1 <= A.length && A.length <= 10 : "out of range, A.length: " + A.length;
		int target = target(A);
		int[] X = solve(B);
		debug(A);
		debug(B);
		debug(X);
		double res = (double)X[target + 10] / (double)sum(X);
		System.out.println(res);
	}

	static boolean DEBUG = false;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

