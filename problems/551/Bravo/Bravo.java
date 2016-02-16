import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	final String a;
	final String b;
	final String c;
	final int[] FA;
	final int[] FB;
	final int[] FC;
	int max;
	String k;
	
	public Bravo(String a, String b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.FA = freq(a);
		this.FB = freq(b);
		this.FC = freq(c);
		this.k = a;
	}

	public static int[] freq(String s) {
		int[] F = new int['z' - 'a' + 1];
		for (char c : s.toCharArray()) {
			F[c - 'a']++;
		}
		return F;
	}

	public static boolean canSub(int[] A, int[] B) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] < B[i]) {
				return false;
			}
		}
		return true;
	}

	public static void doSub(int[] A, int[] B) {
		for (int i = 0; i < A.length; i++) {
			A[i] -= B[i];
		}
	}

	public String makeK(int nb, int nc) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nb; i++) {
			sb.append(b);
		}
		for (int i = 0; i < nc; i++) {
			sb.append(c);
		}
		int[] F = copy(FA);
		doSub(F, mul(FB, nb));
		doSub(F, mul(FC, nc));
		for (int i = 0; i < F.length; i++) {
			for (int j = 0; j < F[i]; j++) {
				sb.append((char)('a' + i));
			}
		}
		return sb.toString();
	}

	public static int[] div(int[] A, int[] B) {
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] < B[i]) {
				return null;
			}
			if (A[i] == 0) {
				R[i] = 0;
			} else {
				if (B[i] == 0) {
					R[i] = A[i];
				} else {
					R[i] = A[i] / B[i];
				}
			}
		}
		return R;
	}

	public static int[] mul(int[] A, int factor) {
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			R[i] = A[i] * factor;
		}
		return R;
	}	

	public static int min(int[] A) {
		if (A == null) {
			return 0;
		}
		int min = A[0];
		for (int i = 0; i < A.length; i++) {
			if (min > A[i]) {
				min = A[i];
			}
		}
		return min;
	}

	public static int[] copy(int[] A) {
		return Arrays.copyOf(A, A.length);
	}

	public String solve() {
		int maxb = min(div(FA, FB));
		int maxc = min(div(FA, FC));
		int max = 0;
		int max_b = 0;
		int max_c = 0;
		int[] F = copy(FA);
		for (int nb = 0; nb <= maxb; nb++) {
			int nc = min(div(F, FC));
			if (max < nb + nc) {
				max = nb + nc;
				max_b = nb;
				max_c = nc;
			}
			if (canSub(F, FB)) {
				doSub(F, FB);
			} else {
				break;
			}
		}
		return makeK(max_b, max_c);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		String c = scanner.nextLine();
		assert 1 <= a.length() && a.length() <= 1e5 : "out of range, a.length(): " + a.length();
		assert 1 <= b.length() && b.length() <= 1e5 : "out of range, b.length(): " + b.length();
		assert 1 <= c.length() && c.length() <= 1e5 : "out of range, c.length(): " + c.length();
		Bravo o = new Bravo(a, b, c);
		System.out.println(o.solve());
	}

}

