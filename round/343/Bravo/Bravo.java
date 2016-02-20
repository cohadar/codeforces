import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		assert 1 <= n && n <= 5000 : "out of range, n: " + n;
		int[] F = new int[366];
		int[] M = new int[366];
		for (int j = 0; j < n; j++) {
			String[] _gab = scanner.nextLine().split(" ");
			String g = _gab[0];
			int a = Integer.valueOf(_gab[1]) - 1;
			int b = Integer.valueOf(_gab[2]) - 1;
			assert 0 <= a && a <= 365 : "out of range, a: " + a;
			assert 0 <= b && b <= 365 : "out of range, b: " + b;
			assert a <= b : "a <= b";
			int[] T = null;
			T = ("F".equals(g)) ? F : M;
			for (int i = a; i <= b; i++) {
				T[i]++;
			}
		}
		int max = 0;
		for (int j = 0; j < F.length; j++) {
			int p = Math.min(F[j], M[j]);
			max = Math.max(max, 2 * p);
		}
		System.out.println(max);
	}

}

