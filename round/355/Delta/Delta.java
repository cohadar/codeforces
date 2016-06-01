import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int pp;
	final List<Integer> X;
	final List<Integer> Y;
	final List<Integer> M;
	
	public Delta(int pp, List<Integer> X, List<Integer> Y, List<Integer> M) {
		this.pp = pp;
		this.X = X;
		this.Y = Y;
		this.M = M;
	}

	public int solve() {
		for (int i = 1; i <= pp; i++) {
			int px = X.get(i-1);
			int py = Y.get(i-1);
			int pm = M.get(i-1);
			for (int i = 0; i < X.length; i++) {
				
			}
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
		List<Integer> X = new ArrayList<>(1+pp); 
		List<Integer> Y = new ArrayList<>(1+pp); 
		List<Integer> M = new ArrayList<>(1+pp); 
		for (int i = 0; i <= pp; i++) {
			X.add(0);
			Y.add(0);
			M.add(0);			
		}
		Arrays.fill(M, Integer.MAX_VALUE);
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				int v = scanner.nextInt();
				X.set(v, x);
				X.set(v, y);
			}
		}
		return new Delta(pp, X, Y, M);
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
