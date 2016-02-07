import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= m && m <= 100 : "out of range, m: " + m;
		boolean[] M = new boolean[m];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			for (int j = 0; j < x; j++) {
				int b = scanner.nextInt() - 1;
				M[b] = true;
			}
		}
		boolean all = true;
		for (boolean b : M) {
			if (b == false) {
				all = false;
				break;
			}
		}
		System.out.println((all) ? "YES" : "NO");
	}

}

