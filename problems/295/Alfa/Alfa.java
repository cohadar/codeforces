import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nn = scanner.nextInt();
		int no = scanner.nextInt();
		int nq = scanner.nextInt();
		long[] A = new long[nn];
		for (int i = 0; i < nn; i++) {
			A[i] = scanner.nextInt();
		}
		int[] L = new int[no];
		int[] R = new int[no];
		int[] D = new int[no];
		for (int i = 0; i < no; i++) {
			L[i] = scanner.nextInt() - 1;
			R[i] = scanner.nextInt() - 1;
			D[i] = scanner.nextInt();
		}
		int[] X = new int[nq];
		int[] Y = new int[nq];
		for (int i = 0; i < nq; i++) {
			X[i] = scanner.nextInt() - 1;
			Y[i] = scanner.nextInt() - 1;
		}
		// solve
		long[] Q = new long[no + 1];
		for (int i = 0; i < nq; i++) {
			Q[X[i]]++;
			Q[Y[i]+1]--;
		}
		for (int i = 1; i < Q.length; i++) {
			Q[i] += Q[i-1];
		}
		long[] S = new long[nn + 1];
		for (int iq = 0; iq < Q.length; iq++) {
			long q = Q[iq];
			if (q != 0) {
				S[L[iq]] += D[iq] * q;
				S[R[iq]+1] -= D[iq] * q;
			}
		}
		for (int i = 1; i < S.length; i++) {
			S[i] += S[i-1];
		}
		for (int i = 0; i < A.length; i++) {
			S[i] += A[i];
		}
		// out
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb.append(S[i]);
			sb.append(' ');
		}
		System.out.println(sb);
	}
	
}

class FastScanner {
	private final BufferedReader in;
	private final StringBuilder sb;
	private StringTokenizer strtok;
	public FastScanner(InputStream is) {
		this.in = new BufferedReader(new InputStreamReader(is));
		this.sb = new StringBuilder();
		this.strtok = null;
	}
	public String next() {
		try {
			if (strtok == null || strtok.hasMoreTokens() == false) {
				strtok = new StringTokenizer(in.readLine());
			}
			return strtok.nextToken();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public long nextLong() {
		return Long.parseLong(next());
	}
	public String nextLine() {
		try {
			if (strtok == null) {
				return in.readLine();
			} else {
				String ret = (strtok.hasMoreTokens()) ? strtok.nextToken("\n") : "";
				strtok = null;
				return ret;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

