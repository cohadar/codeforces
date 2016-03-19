import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	final int n;
	final int q;
	final String[] A;
	final String[] B;
	final Set<String> S = new HashSet<>();
	
	public Bravo(int n, int q, String[] A, String[] B) {
		this.n = n;
		this.q = q;
		this.A = A;
		this.B = B;
	}

	public void rec(String s) {
		if (s.length() == n) {
			S.add(s);
			return;
		}
		String f = s.substring(0, 1);
		for (int i = 0; i < q; i++) {
			if (B[i].equals(f)) {
				rec(A[i] + s.substring(1));
			}
		}
	}

	public int solve() {
		rec("a");
		return S.size();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 6 : "out of range, n: " + n;
		int q = scanner.nextInt();
		assert 1 <= q && q <= 36 : "out of range, q: " + q;
		String[] A = new String[q];
		String[] B = new String[q];
		for (int i = 0; i < q; i++) {
			A[i] = scanner.next();
			B[i] = scanner.next();
		}
		Bravo o = new Bravo(n, q, A, B);
		System.out.println(o.solve());
	}

}

