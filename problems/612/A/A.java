import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static int findA(int n, int p, int q) {
		for (int a = 0; a * p <= n; a++) {
			if ((n - a * p) % q == 0) {
				return a;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] _npq = scanner.nextLine().split(" ");
		int n = Integer.valueOf(_npq[0]);
		int p = Integer.valueOf(_npq[1]);
		int q = Integer.valueOf(_npq[2]);
		char[] C = scanner.nextLine().toCharArray();
		int a = findA(n, p, q);
		if (a == -1) {
			System.out.println("-1");
			return;
		}
		int b = (n - a * p) / q;
		System.out.println(a + b);
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < p; j++) {
				sb.append(C[pos++]);
			}
			sb.append('\n');
		}
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < q; j++) {
				sb.append(C[pos++]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}

