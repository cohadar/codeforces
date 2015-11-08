import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class B {

	static final long PRIME = 1000000007;

	static long inblock(long k, long a, long b) {
		long k9 = (long)Math.pow(10, k);
		long k8 = (long)Math.pow(10, k - 1);
		debug(k, k9, k8);
		long sum = 0;
		for (long i = 0; i < k9; i += a) {
			if (i / k8 != b) {
				sum++;
			}
		}
		return sum;
	}

	static long solve(long k, long[] A, long[] B) {
		debug(k);
		debug(A);
		debug(B);
		long p = 1;
		for (int i = 0; i < A.length; i++) {
			p *= inblock(k, A[i], B[i]);
			p %= PRIME;
		}
		return p;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		assert n % k == 0;
		int l = n / k;
		long[] A = scanArray(scanner, l);
		long[] B = scanArray(scanner, l);
		System.out.println(solve(k, A, B));
	}

	static long[] scanArray(Scanner scanner, int n) {
		long[] A = new long[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextLong();
		}
		return A;
	}

	static boolean DEBUG = false;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
}

