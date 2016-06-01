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
		int c = 0;
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (c + A[i] <= h) {
				c += A[i];
			} else if (c >= k) {
				t += c / k;
				c %= k;
				i--;
			} else {
				t++;
				c = 0;
				i--;
			}
		}
		t += c / k;
		c %= k;
		if (c > 0) {
			t++;
		}
		System.out.println(t);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

