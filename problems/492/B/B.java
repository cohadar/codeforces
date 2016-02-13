import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class B {

	public static double halfd(int l, int r) {
		return (r - l) / 2.0;
	}

	public static double fulld(int l, int r) {
		return (r - l) / 1.0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		int l = scanner.nextInt();
		assert 1 <= l && l <= 1e9 : "out of range, l: " + l;
		TreeSet<Integer> T = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			T.add(scanner.nextInt());
		}
		int prev = T.first();
		double maxd = 0;
		for (int next : T) {
			maxd = Math.max(maxd, halfd(prev, next));
			prev = next;
		}
		maxd = Math.max(maxd, fulld(0, T.first()));
		maxd = Math.max(maxd, fulld(T.last(), l));
		System.out.println(maxd);
	}

}

