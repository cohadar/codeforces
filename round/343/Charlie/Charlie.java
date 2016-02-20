import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	static final int PRIME = (int)1e9 + 7;

	public static long left(int l, int ml) {
		return 1;
	}

	public static long right(int r, int mr) {
		return 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] _nm = scanner.nextLine().split(" ");
		int n = Integer.valueOf(_nm[0]);
		int m = Integer.valueOf(_nm[1]);
		assert 1 <= n && n <= 100_000 : "out of range, n: " + n;
		assert 1 <= m && m <= n : "out of range, m: " + m;
		assert n-m <= 2000 : "n-m <= 2000";
		char[] C = scanner.nextLine().toCharArray();
		assert C.length == m : "C.length == m";
		int[] L = new int[1 + m];
		int[] R = new int[1 + m];
		for (int i = 0; i < m; i++) {
			L[1 + i] = L[1 + i-1];
			R[1 + i] = R[1 + i-1];
			if (C[i] == '(') {
				L[1 + i]++;
			} else {
				R[1 + i]++;
			}
		}
		int ml = 0;
		for (int i = 0; i < m; i++) {
			ml = Math.max(ml, R[1 + i] - L[1 + i]);
		}
		int mr = ml + L[1 + m-1] - R[1 + m-1]);
		if (ml + m + mr > n) {
			System.out.println(0);
			return;
		}
		long ans = 0;
		for (int l = ml; l + m + mr <= n; l++) {
			int r = n - m - l;
			long cl = left(l, ml);
			long cr = right(r, mr);
			ans += (long)cl * (long)cr;
			ans %= PRIME;
		}
		System.out.println(ans);
	}

}

