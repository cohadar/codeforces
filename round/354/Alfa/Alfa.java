import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nn = scanner.nextInt();
		int[] A = new int[nn];
		int[] B = new int[nn];
		int imin = -1;
		int imax = -1;
		for (int i = 0; i < nn; i++) {
			A[i] = scanner.nextInt();
			B[i] = A[i];
			if (A[i] == 1) {
				imin = i;
			}
			if (A[i] == nn) {
				imax = i;
			}
		}
		int l = Math.min(imin, imax);
		int r = Math.max(imin, imax);
		swap(A, 0, l);
		swap(B, r, nn-1);
		System.out.println(Math.max(dist(A), dist(B)));		
	}

	public static int dist(int[] A) {
		int imin = -1;
		int imax = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				imin = i;
			}
			if (A[i] == A.length) {
				imax = i;
			}
		}
		return Math.abs(imin - imax);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

