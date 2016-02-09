import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		int s = scanner.nextInt();
		assert 1 <= s && s <= 1000 : "out of range, s: " + s;
		int[] T = new int[1001];
		for (int i = 0; i < n; i++) {
			int f = scanner.nextInt();
			int t = scanner.nextInt();
			T[f] = Math.max(T[f], t);
		}
		int t = 0;
		for (int f = s; f >= 1; f--) {
			if (t < T[f]) {
				t = T[f];
			}
			t++;
		}
		System.out.println(t);
	}

}

