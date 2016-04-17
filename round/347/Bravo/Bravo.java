import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int[] ab(int n, int plus, int minus) {
		int min = plus * 1 - minus * n;
		int max = plus * n - minus * 1;		
		if (min <= n && n <= max) {
			int a = n + minus;
			if (a < plus) {
				a = plus;
			}
			int b = a - n;
			return new int[] {a, b};
		}
		return null;
	}

	public static boolean positive(int i, String[] ss) {
		if (i == 0) {
			return true;
		}
		return "+".equals(ss[2*i-1]);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String ss[] = s.split(" ");
		int n = Integer.valueOf(ss[ss.length - 1]);
		int len = s.length();
		int quest = 0;
		int plus = 1;
		int minus = 0;
		for (int i = 0; i < len; i++) {
			switch (s.charAt(i)) {
			case '?':
				quest++;
				break;
			case '+':
				plus++;
				break;
			case '-':
				minus++;
				break;
			}
		}
		int[] ab = ab(n, plus, minus);
		if (ab == null) {
			System.out.println("Impossible");
			return;
		}
		System.out.println("Possible");
		int a = ab[0];
		int b = ab[1];
		int R[] = new int[quest];
		for (int i = 0; i < R.length; i++) {
			if (positive(i, ss)) {
				R[i] = 1;
				a--;
			} else {
				R[i] = 1;
				b--;
			}
		}
		for (int i = 0; i < R.length; i++) {
			if (positive(i, ss)) {
				if (a >= n - 1) {
					R[i] += (n - 1);
					a -= (n - 1);
				} else {
					R[i] += a;
					a = 0;
				}
			} else {
				if (b >= n - 1) {
					R[i] += (n - 1);
					b -= (n - 1);
				} else {
					R[i] += b;
					b = 0;
				}
			}
		}		
		for (int i = 0; i < R.length; i++) {
			s = s.replaceFirst("\\?", String.valueOf(R[i]));
		}
		System.out.println(s);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

