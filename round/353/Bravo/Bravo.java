import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	final int n;
	final int a;
	final int b;
	final int c;
	final int d;
	
	public Bravo(int n, int a, int b, int c, int d) {
		this.n = n;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public boolean ok(int f) {
		return 1 <= f && f <= n;
	}

	public long solve() {
		long ret = 0;
		for (int x = 1; x <= n; x++) {
			int y = b - c + x;
			int z = a - d + x;
			int t = a + b - c - d + x;
			if (ok(y) && ok(z) && ok(t)) {
				ret++;
			}
		}
		return n * ret;
	}

	public static Bravo load(Scanner scanner) {
		int n = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		return new Bravo(n, a, b, c, d);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println(o.solve());
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}
