import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	final int h;
	final int w;
	final char[][] C;
	final int[][] A;
	
	public Charlie(int h, int w, char[][] C) {
		this.h = h;
		this.w = w;
		this.C = C;
		this.A = new int[1 + h][1 + w];
	}
	
	public void solve() {
		for (int y = 1; y <= h; y++) {
			for (int x = 1; x <= w; x++) {
				if (C[y][x] == '.') {
					if (C[y-1][x] == '.') {
						A[y][x]++;
					}
					if (C[y][x-1] == '.') {
						A[y][x]++;
					}					
				}
			}
		}
		debug(A);
		for (int y = 1; y <= h; y++) {
			for (int x = 1; x <= w; x++) {
				A[y][x] += A[y][x-1];
			}
		}
		for (int x = 1; x <= w; x++) {
			for (int y = 1; y <= h; y++) {
				A[y][x] += A[y-1][x];
			}
		}
	}

	public int query(int y1, int x1, int y2, int x2) {
		return A[y2][x2] - A[y1-1][x2] - A[y2][x1-1] + A[y1-1][x1-1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] _hw = scanner.nextLine().split(" ");
		int h = Integer.valueOf(_hw[0]);
		int w = Integer.valueOf(_hw[1]);
		char[][] C = new char[h][];
		for (int y = 0; y < h; y++) {
			C[y] = scanner.nextLine().toCharArray();
			assert C[y].length == w;
		}
		Charlie o = new Charlie(h, w, C);
		o.solve();
		int q = Integer.valueOf(scanner.nextLine());
		assert 1 <= q && q <= 1e5 : "out of range, q: " + q;
		StringBuilder sb = new StringBuilder();
		while (q-->0) {
			int y1 = scanner.nextInt();
			int x1 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int x2 = scanner.nextInt();
			sb.append(o.query(y1, x1, y2, x2));
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

	static void debug(int[][] M) {
		if (!DEBUG) { return; }
		for (int y = 0; y < M.length; y++) {
			for (int x = 0; x < M[0].length; x++) {
				System.err.print(M[y][x]);
			}
			System.err.println();
		}
		System.err.println();
	}

}

