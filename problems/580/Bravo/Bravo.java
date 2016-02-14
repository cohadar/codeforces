import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	static class Friend implements Comparable<Friend> {
		final int m;
		final int s;
		Friend(int m, int s) {
			this.m = m;
			this.s = s;
		}
		public int compareTo(Friend that) {
			if (this.m == that.m) {
				return Integer.compare(this.s, that.s);
			} else {
				return Integer.compare(this.m, that.m);
			}
		}
		public String toString() {
			return String.format("(m=%d, s=%d)", m, s);
		}	
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		assert 1 <= d && d <= 1e9 : "out of range, d: " + d;
		Friend[] F = new Friend[n];
		for (int i = 0; i < n; i++) {
			int m = scanner.nextInt();
			int s = scanner.nextInt();
			F[i] = new Friend(m ,s);
		}
		Arrays.sort(F);
		int[] M = new int[n];
		long[] C = new long[1 + n];
		long cumul = 0;
		for (int i = 0; i < n; i++) {
			M[i] = F[i].m;
			cumul += F[i].s;
			C[1 + i] = cumul;
		}
		long max = 0;
		for (int b = 0; b < n; b++) {
			int a = Arrays.binarySearch(M, M[b] - d);
			if (a < 0) {
				a = ~a;
			} else {
				a++;
			}
			long local = C[1 + b] - C[1 + a - 1];
			max = Math.max(max, local);
		}
		System.out.println(max);
	}

}

