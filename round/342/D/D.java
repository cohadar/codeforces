import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class D {

	final int[] N;
	int[] A;
	int[] B;
	
	public D(int[] N, int n) {
		this.N = N;
		this.A = new int[n];
		this.B = new int[n];
	}

	int[] solve(int i) {
		return null;
	}

	int[] solve() {
		return solve(0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] N = loadN(scanner);
		D d = new D(N, N.length);
		int[] solution = d.solve();
		if (solution == null) {
			d = new D(N, N.length - 1);
			solution = d.solve();
		}
		System.out.println((solution == null) ? "0" : join(solution, ""));
	}

	static int[] loadN(Scanner scanner) {
		char[] C = scanner.nextLine().toCharArray();
		int[] N = new int[C.length];
		for (int i = 0; i < C.length; i++) {
			N[i] = C[i] - '0';
		}
		return N;
	}

	static String join(int[] A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int o : A) {
			sb.append(o);
			sb.append(delimiter);
		}
		return sb.toString();
	}

	static int flip(int x) {
		String r = new StringBuilder(String.valueOf(x)).reverse().toString();
		return Integer.parseInt(r, 10);
	}

	static void test() {
		for (int i = 0; i < 10000; i++) {
			int a = i;
			int b = flip(i);
			System.out.printf("%d + %d = %d\n", a, b, a + b);
		}
	}

}

