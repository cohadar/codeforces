import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int[] cumul(char[] S) {
		int[] C = new int[S.length];
		int cumul = 0;
		for (int i = 1; i < S.length; i++) {
			if (S[i] == S[i - 1]) {
				cumul++;
			}
			C[i] = cumul;
		}
		return C;
	}

	public static int query(int[] C, int l, int r) {
		if (l > r) {
			return 0;
		}
		if (l == 0) {
			return C[r];
		}
		return C[r] - C[l - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] S = scanner.nextLine().toCharArray();
		int n = S.length;
		assert 2 <= n && n <= 2e5 : "out of range, n: " + n;
		int m = scanner.nextInt();
		assert 1 <= m && m <= 1e5 : "out of range, m: " + m;
		StringBuilder sb = new StringBuilder();
		int[] C = cumul(S);
		for (int i = 0; i < m; i++) {
			int l = scanner.nextInt() - 1;
			int r = scanner.nextInt() - 1;
			sb.append(query(C, l + 1, r));
			sb.append('\n');
		}
		System.out.println(sb);
	}

}

