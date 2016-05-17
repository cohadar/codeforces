import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	static final int INF = Integer.MAX_VALUE / 2;

	final int ny;
	final int nx;
	final int[][] M;
	final int[][] D;
	
	public Bravo(int ny, int nx, int[][] M) {
		this.ny = ny;
		this.nx = nx;
		this.M = M;
		this.D = new int[ny][nx];
	}

	public int minRow(int y) {
		int ret = 0;
		for (int x = 0; x < nx; x++) {
			ret += D[y][x];
		}
		return ret;
	}

	public int minColumn(int x) {
		int ret = 0;
		for (int y = 0; y < ny; y++) {
			ret += D[y][x];
		}
		return ret;
	}

	public int solve() {
		boolean[] P = sieve(1299709 + 1); // 100000th prime
		NavigableSet<Integer> S = new TreeSet<>();
		for (int i = 0; i < P.length; i++) {
			if (P[i]) {
				S.add(i);	
			}
		}
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				D[y][x] = S.ceiling(M[y][x]) - M[y][x];
			}
		}
		int min = INF;
		for (int y = 0; y < ny; y++) {
			min = Math.min(min, minRow(y));
		}
		for (int x = 0; x < nx; x++) {
			min = Math.min(min, minColumn(x));
		}
		return min;
	}

	public static Bravo load(Scanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int[][] M = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				M[y][x] = scanner.nextInt();
			}
		}
		return new Bravo(ny, nx, M);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println(o.solve());
	}

	public static boolean[] sieve(int n) {
		boolean[] P = new boolean[n];
		Arrays.fill(P, true);
		P[0] = false;
		P[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (P[i]) {
				for (int j = i * i; j < n; j += i) {
					P[j] = false;
				}
			}
		}
		return P;
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

	static void debug(int[][] M) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < M.length; y++) {
			for (int x = 0; x < M[0].length; x++) {
				sb.append(String.format("%2d ", M[y][x]));
			}
			sb.append('\n');
		}
		sb.append('\n');
		System.err.print(sb.toString());
	}

}
