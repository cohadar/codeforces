import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static boolean same(int[] A, int[] B) {
		for (int i = 0; i < 3; i++) {
			if (A[i] != B[i]) {
				return false;
			}
		}
		return true;
	}	

	static int sum(int[] A) {
		int s = 0;
		for (int i = 0; i < A.length; i++) {
			s += A[i];
		}
		return s;
	}

	public static boolean canDo(int[] A, int[] B) {
		if (same(A, B)) {
			return true;
		}
		if (A[0] >= 2) {
			if (canDo(new int[]{A[0]-2, A[1]+1, A[2]}, B)) {
				return true;
			}
			if (canDo(new int[]{A[0]-2, A[1], A[2]+1}, B)) {
				return true;
			}
		}
		if (A[1] >= 2) {
			if (canDo(new int[]{A[0]+1, A[1]-2, A[2]}, B)) {
				return true;
			}
			if (canDo(new int[]{A[0], A[1]-2, A[2]+1}, B)) {
				return true;
			}
		}
		if (A[2] >= 2) {
			if (canDo(new int[]{A[0]+1, A[1], A[2]-2}, B)) {
				return true;
			}
			if (canDo(new int[]{A[0], A[1]+1, A[2]-2}, B)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] A = new int[3];
		int[] B = new int[3];
		A[0] = scanner.nextInt();
		A[1] = scanner.nextInt();
		A[2] = scanner.nextInt();
		B[0] = scanner.nextInt();
		B[1] = scanner.nextInt();
		B[2] = scanner.nextInt();
		System.out.println((canDo(A, B)) ? "Yes" : "No");
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

