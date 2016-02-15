import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] _nt = scanner.nextLine().split(" ");
		int n = Integer.valueOf(_nt[0]);
		int t = Integer.valueOf(_nt[1]);
		assert 1 <= n && n <= 50 : "out of range, n: " + n;
		assert 1 <= t && t <= 50 : "out of range, t: " + t;
		char[] Q = scanner.nextLine().toCharArray();
		while (t-->0) {
			for (int i = 1; i < Q.length; i++) {
				if (Q[i - 1] == 'B' && Q[i] == 'G') {
					Q[i - 1] = 'G';
					Q[i] = 'B';
					i++;
				}
			}
		}
		System.out.println(new String(Q));
	}

}

