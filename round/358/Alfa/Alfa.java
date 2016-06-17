import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static int[] solve(int n) {
		int[] N = new int[10];
		// Arrays.fill(N, n / 10);
		// n = n % 10;
		// for (int i = 0; i < n; i++) {
		// 	N[i]++;
		// }
		for (int i = 1; i <= n; i++) {
			N[i % 10]++;
		}
		return N;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] N = solve(n);
		int[] M = solve(m);
		long res = 0;
		for (int i = 0; i < N.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if ((i + j) % 5 == 0) {
					res += (N[i] * (long)M[j]);
				}
			}
		}
		System.out.println(res);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

