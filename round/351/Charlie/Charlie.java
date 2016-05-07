import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 5000 : "out of range, n: " + n;
		int[] C = new int[n];
		for (int i = 0; i < n; i++) {
			C[i] = scanner.nextInt() - 1;
		}
		int[] D = new int[n];
		for (int l = 0; l < n; l++) {
			int[] N = new int[n];
			int d = C[l];
			N[d]++;
			D[d]++;
			for (int r = l+1; r < n; r++) {
				int c = C[r];
				N[c]++;
				if (N[d] < N[c]) {
					d = c;
				} else if (N[d] == N[c] && d > c) {
					d = c;
				}
				D[d]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(D[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}

	static String join(int[] A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int a : A) {
			sb.append(a);
			sb.append(delimiter);
		}
		if (sb.length() >= delimiter.length()) {
			sb.setLength(sb.length() - delimiter.length());
		}			
		return sb.toString();
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

