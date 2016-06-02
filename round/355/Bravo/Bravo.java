import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		int k = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		long c = 0;
		long t = 0;
		int i = 0;
		while (i < n) {
			while (i < n && c + A[i] <= h) {
				c += A[i++];
			}
			if (c <= k) {
				c = 0;
				t++;
			} else {
				t += c / k;
				c %= k;
			}
		}
		if (c > 0) {
			t++;
		}
		System.out.println(t);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

