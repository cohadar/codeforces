import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static int[] tonum(char[] C) {
		int[] D = new int[C.length];
		for (int i = 0; i < C.length; i++) {
			D[i] = C[i] - '0';
		}
		return D;
	}

	public static String pick1(int[] D) {
		for (int i = 0; i < D.length; i++) {
			if (D[i] % 8 == 0) {
				return String.valueOf(D[i]);
			}
		}
		return null;
	}

	public static String pick2(int[] D) {
		for (int a = 0; a < D.length; a++) {
			for (int b = a + 1; b < D.length; b++) {
				int d = D[a] * 10 + D[b];
				if (d % 8 == 0) {
					return String.valueOf(d);
				}
			}
		}
		return null;
	}

	public static String pick3(int[] D) {
		for (int a = 0; a < D.length; a++) {
			for (int b = a + 1; b < D.length; b++) {
				for (int c = b + 1; c < D.length; c++) {
					int d = D[a] * 100 + D[b] * 10 + D[c];
					if (d % 8 == 0) {
						return String.valueOf(d);
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		int[] D = tonum(C);
		String ans = pick1(D);
		if (ans == null) {
			ans = pick2(D);
		}
		if (ans == null) {
			ans = pick3(D);
		}
		if (ans == null) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(ans);
		}
	}

}

