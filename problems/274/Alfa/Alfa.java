import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int k = scanner.nextInt();
		assert 1 <= k && k <= 1e9 : "out of range, k: " + k;
		if (k == 1) {
			System.out.println(n);
			return;
		}
		TreeSet<Integer> T = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			assert 1 <= a && a <= 1e9 : "out of range, a: " + a;
			T.add(a);
		}
		int count = 0;
		while (!T.isEmpty()) {
			int last = T.pollLast();
			int c = 1;
			while (last % k == 0) {
				last /= k;
				if (T.remove(last)) {
					c++;
				} else {
					break;
				}
			}
			count += (c + 1) / 2;
		}
		System.out.println(count);
	}

}

