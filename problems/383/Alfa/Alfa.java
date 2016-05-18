import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static final int INF = Integer.MAX_VALUE / 2;

	public static int[] load(Scanner scanner) {
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] A = new int[n];
		int j = 0;
		int sum = 0;
		for (char c : scanner.nextLine().toCharArray()) {
			if (c == '0') {
				if (A[j] > 0) {
					j++;
				}
				A[j]--;
				sum++;
			} else if (c == '1') {
				if (A[j] < 0) {
					j++;
				}
				A[j]++;
				sum++;
			}
		}
		assert sum == n;
		return Arrays.copyOf(A, j + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] A = load(scanner);
		debug(A);
		int[] L = new int[A.length];
		int[] R = new int[A.length];
		int cumul = 0;
		for (int l = 0; l < L.length; l++) {
			L[l] = cumul;
			if (A[l] > 0) {
				cumul += A[l];
			}
		}
		cumul = 0;
		for (int r = R.length - 1; r >= 0; r--) {
			R[r] = cumul;
			if (A[r] < 0) {
				cumul -= A[r];
			}
		}
		debug(L);
		debug(R);
		int[] C = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			C[i] = L[i] + R[i];
		}
		int nc = A.length;
		boolean[] B = new boolean[nc];
		int lost = 0;
		while (nc > 0) {
			int imin = -1;
			int min = INF;
			int save = 0;
			for (int i = 0; i < C.length; i++) {
				if (B[i]) {
					continue;
				}
				if (min > C[i]) {
					min = C[i];
					imin = i;
				}
			}
			assert B[imin] == false;
			nc--;
			C[imin] = 0;
			B[imin] = true;
			lost += A[imin];
			if (A[imin] > 0) {
				for (int k = imin + 1; k < C.length; k++) {
					if (B[k] == false) {
						C[k] -= A[imin];
					}
				}
			} else {
				for (int k = imin - 1; k >= 0; k--) {
					if (B[k] == false) {
						C[k] += A[imin];
					}
				}
			}
		}
		debug(C);
		System.out.println(lost);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
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
