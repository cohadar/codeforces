import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// load cumul of array
		long[] C = new long[1 + n];
		long cumul = 0;
		for (int i = 0; i < n; i++) {
			cumul += scanner.nextInt();
			C[1 + i] = cumul;
		}
		// is it divisible by 3?
		long sum = C[n];
		if (sum % 3 != 0) {
			System.out.println(0);
			return;
		}
		sum /= 3;
		// count total double sums
		int ds = 0;
		for (int i = 0; i < n; i++) {
			if (C[1 + i] == 2 * sum) {
				ds++;
			}
		}
		debug(C);
		debug("sum", sum);
		debug("ds", ds);
		// count ways
		int count = 0;
		for (int a = 0; a < n; a++) {
			if (C[1 + a] == 2 * sum) {
				ds--;
			}			
			if (C[1 + a] == sum) {
				count += ds;
			} 
		}
		System.out.println(count);
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

