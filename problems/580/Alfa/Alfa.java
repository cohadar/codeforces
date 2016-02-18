import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		int l = 1;
		int d = 1;
		int a0 = scanner.nextInt();
		for (int k = 1; k < n; k++) {
			int a1 = scanner.nextInt();
			if (a0 <= a1) {
				d++;
			} else {
				d = 1;
			}
			l = Math.max(l, d);
			a0 = a1;
		}
		System.out.println(l);
	}

}

