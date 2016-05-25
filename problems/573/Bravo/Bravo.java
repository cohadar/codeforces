import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			A[i] = scanner.nextInt();
		}
		int count = 0;
		for (int m = 1; m <= n; m++) {
			int l = m - 1;
			int r = m + 1;
			int v = Math.min(A[m], Math.min(A[l], A[r]) + 1);
			count = Math.max(count, v);
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

