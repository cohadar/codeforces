import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[5];
		for (int i = 0; i < n; i++) {
			A[scanner.nextInt()]++;
		}
		int count = A[4];
		int x13 = Math.min(A[1], A[3]);
		count += x13;
		A[1] -= x13;
		A[3] -= x13;
		count += A[3];
		count += A[2] / 2;
		A[2] %= 2;
		if (A[2] == 1) {
			count++;
			A[1] -= Math.min(2, A[1]);
		}
		count += A[1] / 4;
		if (A[1] % 4 != 0) {
			count++;
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

