import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int ny;
	final int nx;
	final int pp;
	final int[][] D;
	final int[][] M;
	
	public Delta(int ny, int nx, int pp, int[][] D) {
		this.ny = ny;
		this.nx = nx;
		this.pp = pp;
		this.D = D;
		this.M = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			Arrays.fill(M[y], Integer.MAX_VALUE);
		}
	}

	public int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public int solve() {
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				if (D[y][x] == 1) {
					M[y][x] = dist(0, 0, x, y);
				}
			}
		}
		return -1;
	}

	public static Delta load(Scanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int pp = scanner.nextInt();
		int[][] D = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				D[y][x] = scanner.nextInt();
			}
		}
		return new Delta(ny, nx, pp, D);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}
