import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[] A = new boolean[91];
		for (int i = 0; i < n; i++) {
			A[scanner.nextInt()] = true;
		}
		int m = 0;
		int b = 0;
		for (int i = 1; i < A.length; i++) {
			m++;
			if (A[i]) {
				b = 0;
			} else {
				b++;
			}
			if (b == 15) {
				break;
			}
		}
		System.out.println(m);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

