import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		int[] A = new int[n];
		int[] I = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt() - 1;	
			I[A[i]] = i;
		}
		long sum = 0;
		for (int i = 0; i < m; i++) {
			int b = scanner.nextInt() - 1;
			int index = I[b];
			sum += (index / k) + 1;
			if (index > 0) {
				int a = A[index - 1];
				swap(A, index-1, index);
				swap(I, a, b);
			}
			// debug(A, I);
		}
		for (int i = 0; i < A.length; i++) {
			assert i == I[A[i]];
		}
		System.out.println(sum);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

