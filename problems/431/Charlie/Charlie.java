import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	static final int PRIME = (int)1e9 + 7;

	final int n;
	final int k;
	final int d;
	final long[] D;
	final long[] E;
	
	public Charlie(int n, int k, int d) {
		this.n = n;
		this.k = k;
		this.d = d;
		this.D = new long[1 + n];
		this.E = new long[1 + n];
	}

	public long dx(int x) {
		long sum = 0;
		for (int i = 1; i <= k; i++) {
			if (x - i >= 0) {
				sum += D[x - i];
			}
		}
		return sum;
	}

	public long ex(int x) {
		long sum = 0;
		for (int i = 1; i <= k; i++) {
			if (x - i >= 0) {
				if (i >= d) {
					sum += D[x - i];
				} else {
					sum += E[x - i];
				}
			}
		}
		return sum;
	}

	public long solve() {
		D[0] = 1;
		E[0] = 0;
		for (int x = 1; x <= n; x++) {
			D[x] = dx(x) % PRIME;
			E[x] = ex(x) % PRIME;
		}
		debug(n, k, d);
		debug("D", D);
		debug("E", E);
		return E[n];
	}

	public static Charlie load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int d = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= k && k <= 100 : "out of range, k: " + k;
		assert 1 <= d && d <= k : "out of range, d: " + d;
		return new Charlie(n, k, d);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Charlie o = Charlie.load(scanner);
		System.out.println(o.solve());
	}

	static boolean DEBUG = false;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}
