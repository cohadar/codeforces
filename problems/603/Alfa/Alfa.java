import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		scanner.nextLine();
		char[] A = scanner.nextLine().toCharArray();
		assert A.length == n;
		int d0 = 0;
		int d1 = 0;
		int e0 = 0;
		int e1 = 0;
		int f0 = 0;
		int f1 = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == '0') {
				f0 = 1 + f1;
			} else {
				f1 = 1 + f0;
			}
			if (A[i] == '0') {
				e1 = 1 + e0;
			} else {
				e0 = 1 + e1;
			}
			e0 = Math.max(e0, f0);
			e1 = Math.max(e1, f1);
			if (A[i] == '0') {
				d0 = 1 + d1;
			} else {
				d1 = 1 + d0;
			}
			d0 = Math.max(d0, e0);
			d1 = Math.max(d1, e1);
		}
		int res = Math.max(d0, d1);
		System.out.println(res);
	}

}

