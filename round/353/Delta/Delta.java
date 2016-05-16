import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int nn;
	final int[] A;
	final int[] R;
	final Map<Integer, Integer> M = new HashMap<>();

	public Delta(int nn, int[] A) {
		this.nn = nn;
		this.A = A;
		for (int i = 0; i < A.length; i++) {
			M.put(A[i], i);
		}
		this.R = new int[nn - 1];
	}

	public int[] solve() {
		TreeSet<Integer> T = new TreeSet<>();
		T.add(A[0]);
		for (int i = 1; i < A.length; i++) {
			Integer h = T.higher(A[i]);
			Integer l = T.lower(A[i]);
			if (h == null) {
				R[i-1] = l;
			} else if (l == null) {
				R[i-1] = h;
			} else {
				R[i-1] = (M.get(l) > M.get(h)) ? l : h;
			}
			T.add(A[i]);
		}
		return R;
	}

	public static Delta load(FastScanner scanner) {
		int nn = scanner.nextInt();
		assert 2 <= nn && nn <= 1e5 : "out of range, nn: " + nn;
		int[] A = new int[nn];
		for (int i = 0; i < nn; i++) {
			A[i] = scanner.nextInt();
		}
		return new Delta(nn, A);
	} 

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(join(" ", o.solve()));
	}

	static String join(String delimiter, int[] A) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i]);
			sb.append(' ');
		}
		return sb.toString();
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

