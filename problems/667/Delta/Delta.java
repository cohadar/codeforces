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
	final List<List<Cell>> LL;
	
	public Delta(int ny, int nx, int pp, int[][] D, List<List<Cell>> LL) {
		this.ny = ny;
		this.nx = nx;
		this.pp = pp;
		this.D = D;
		this.LL = LL;
	}

	public void solve(List<Cell> A, List<Cell> B) {
		for (Cell b : B) {
			for (Cell a : A) {
				b.d = Math.min(b.d, a.d + a.dist(b));
			}
		}
	}

	public int solve() {
		for (int i = 1; i < pp; i++) {
			solve(LL.get(i-1), LL.get(i));
		}
		return LL.get(pp-1).get(0).d;
	}

	public static Delta load(Scanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int pp = scanner.nextInt();
		List<List<Cell>> LL = new ArrayList<>(pp);
		for (int i = 0; i < pp; i++) {
			LL.add(new ArrayList<Cell>());
		}
		int[][] D = new int[ny][nx];
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				D[y][x] = scanner.nextInt() - 1;
				Cell c = new Cell(x, y, (D[y][x] == 0) ? x + y : Integer.MAX_VALUE);
				LL.get(D[y][x]).add(c);
			}
		}

		return new Delta(ny, nx, pp, D, LL);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
	}

}

class Cell {
	final int x;
	final int y;
	int d;
	Cell(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
	public int dist(Cell b) {
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y);
	}
	public String toString() {
		return String.format("(x=%d, y=%d, d=%d)", x, y, d);
	}	
}
