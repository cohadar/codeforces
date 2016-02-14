import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 0 <= n && n <= 1e6 : "out of range, n: " + n;
		assert 0 <= m && m <= 1e6 : "out of range, m: " + m;
		if (m == 0) {
			System.out.println(2 * n);
			return;
		}
		if (n == 0) {
			System.out.println(3 * m);
			return;
		}
		TreeSet<Integer> N = new TreeSet<>();
		TreeSet<Integer> M = new TreeSet<>();
		int j = 1;
		while (N.size() < n) {
			if (j % 2 == 0 && j % 3 != 0) {
				N.add(j);
			}
			j++;
		}
		j = 1;
		while (M.size() < m) {
			if (j % 2 != 0 && j % 3 == 0) {
				M.add(j);
			}
			j++;
		}
		j = 1;
		while (j < N.last() && j < M.last()) {
			if (j % 2 == 0 && j % 3 == 0) {
				if (N.last() > M.last()) {
					N.pollLast();
					N.add(j);
				} else {
					M.pollLast();
					M.add(j);
				}
			}
			j++;
		}
		while (j < N.last()) {
			if (j % 2 == 0 && j % 3 == 0) {
				N.pollLast();
				N.add(j);
			}
			j++;
		}
		while (j < M.last()) {
			if (j % 2 == 0 && j % 3 == 0) {
				M.pollLast();
				M.add(j);
			}
			j++;
		}
		System.out.println(Math.max(N.last(), M.last()));
	}

}

