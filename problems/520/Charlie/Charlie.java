import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	static final int PRIME = (int)1e9 + 7;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String S = scanner.next();
		int[] F = new int[4];
		for (int i = 0; i < S.length(); i++) {
			F["ATGC".indexOf(S.charAt(i))]++;
		}
		Arrays.sort(F);
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (F[i] == F[3]) {
				count++;
			}
		}
		long p = 1;
		for (int i = 0; i < n; i++) {
			p *= count;
			p %= PRIME;
		}
		System.out.println(p);
	}

}

