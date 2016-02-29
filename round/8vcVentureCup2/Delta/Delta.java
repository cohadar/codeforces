import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Delta {

	public static int[] cumul(int[] A) {
		int[] C = new int[A.length];
		C[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			C[i] = A[i] + C[i - 1];
		}
		return C;
	}

	public static int solve(int[] CA, int[] CB, int p, int k) {
		int n = CA.length;
		int total = 0;
		if (p > 0) {
			total += CB[p - 1];
		}
		total += CA[n - 1];
		int pk = Math.min(n - 1, p + k);
		total -= CA[pk];
		return total;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int q = scanner.nextInt();
		debug("k", k);
		int[] A = new int[n];
		int[] B = new int[n];
		List<Integer> P = new ArrayList<>();
		for (int i = 0; i < q; i++) {
			int t = scanner.nextInt();
			if (t == 1) {
				int d = scanner.nextInt() - 1;
				int x = scanner.nextInt();
				A[d] += x;
				B[d] += x;
				A[d] = Math.min(A[d], a);
				B[d] = Math.min(B[d], b);
			} else {
				int p = scanner.nextInt() - 1;
				P.add(p);
			}
		}
		int[] CA = cumul(A);
		int[] CB = cumul(B);
		debug(A);
		debug(B);
		debug(CA);
		debug(CB);
		StringBuilder sb = new StringBuilder();
		for (int p : P) {
			debug("p", p);
			sb.append(solve(CA, CB, p, k));
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

