import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static int compact(int[] A, int l) {
		while (l >= 2) {
			if (A[l - 2] == A[l - 1]) {
				A[l - 2]++;
				l--;
			} else {
				break;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		int l = 0;
		for (int i = 0; i < n; i++) {
			A[l++] = 1;
			l = compact(A, l);
		}
		System.out.println(join(A, l, " "));
	}

	static String join(int[] A, int l, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			sb.append(A[i]);
			sb.append(delimiter);
		}
		return sb.toString();
	}

}

