import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e6 : "out of range, n: " + n;
		char[] C = String.valueOf(n).toCharArray();
		List<Integer> A = new ArrayList<>();
		while (true) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C.length; i++) {
				if (C[i] > '0') {
					sb.append(1);
					C[i]--;
				} else {
					sb.append(0);
				}
			}
			int d = Integer.parseInt(sb.toString(), 10);
			if (d == 0) {
				break;
			}
			A.add(d);			
		}
		System.out.println(A.size());
		System.out.println(join(A, " "));
	}

	static String join(List<Integer> A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int a : A) {
			sb.append(a);
			sb.append(delimiter);
		}
		if (sb.length() >= delimiter.length()) {
			sb.setLength(sb.length() - delimiter.length());
		}			
		return sb.toString();
	}

}

