import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void pack(Integer[][] L, Integer[][] R, int im) {
		int n = L.length;
		for (int i = 0; i < n; i++) {
			if (L[i][0] == null) {
				L[i][0] = im;
				return;
			}
			if (R[i][0] == null) {
				R[i][0] = im;
				return;
			}
		}
		for (int i = 0; i < n; i++) {
			if (L[i][1] == null) {
				L[i][1] = L[i][0];
				L[i][0] = im;
				return;
			}
			if (R[i][1] == null) {
				R[i][1] = R[i][0];
				R[i][0] = im;
				return;
			}
		}
	}

	public static int unpack(Integer[][] L, Integer[][] R) {
		int n = L.length;
		for (int i = 0; i < n; i++) {
			if (L[i][0] != null) {
				int ret = L[i][0];
				L[i][0] = null;
				return ret;
			}
			if (L[i][1] != null) {
				int ret = L[i][1];
				L[i][1] = null;
				return ret;
			}
			if (R[i][0] != null) {
				int ret = R[i][0];
				R[i][0] = null;
				return ret;
			}
			if (R[i][1] != null) {
				int ret = R[i][1];
				R[i][1] = null;
				return ret;
			}
		}
		assert false : "SNH";
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= m && m <= 4 * n : "out of range, m: " + m;
		Integer[][] L = new Integer[n][2];
		Integer[][] R = new Integer[n][2];
		for (int i = 0; i < m; i++) {
			pack(L, R, i + 1);
		}
		for (int i = 0; i < m; i++) {
			System.out.print(unpack(L, R));
			System.out.print(' ');
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

