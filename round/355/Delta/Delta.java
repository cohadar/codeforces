import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int pp;
	final List<List<Point>> LL;
	
	public Delta(int pp, List<List<Point>> LL) {
		this.pp = pp;
		this.LL = LL;
	}

	public int solve() {
		for (int i = 1; i <= pp; i++) {
			List<Point> prev = LL.get(i-1);
			List<Point> curr = LL.get(i);
			for (Point c : curr) {
				c.min = Integer.MAX_VALUE;
				for (Point p : prev) {
					c.min = Math.min(c.min, c.dist(p) + p.min);
				}
			}
		}
		return LL.get(pp).get(0).min;
	}

	public static Delta load(Scanner scanner) {
		int ny = scanner.nextInt();
		int nx = scanner.nextInt();
		int pp = scanner.nextInt();
		List<List<Point>> LL = new ArrayList<>();
		for (int i = 0; i <= pp; i++) {
			LL.add(new ArrayList<Point>());
		}
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				int v = scanner.nextInt();
				LL.get(v).add(new Point(x, y));
			}
		}
		LL.get(0).add(new Point(0, 0));
		return new Delta(pp, LL);
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

class Point {
	final int x;
	final int y;
	public int min;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.min = 0;
	}
	public int dist(Point p) {
		return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
	}
	public String toString() {
		return String.format("(x=%d, y=%d, min=%d)", x, y, min);
	}	
}