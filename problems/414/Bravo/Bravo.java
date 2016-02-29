import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	static final int PRIME = (int)1e9 + 7;

	final int n;
	final int k;
	final long[][] D;
	final List<Integer>[] A;
	
	public Bravo(int n, int k) {
		this.n = n;
		this.k = k;
		this.D = new long[k][1 + n];
		this.A = new List[1 + n];
		for (int b = 1; b < A.length; b++) {
			A[b] = new ArrayList<>();
			for (int a = 1; a <= b; a++) {
				if (b % a == 0) {
					A[b].add(a);
				}
			}
		}
	}

	static long sum(long[] A, int l, int r) {
		long s = 0;
		for (int i = l; i <= r; i++) {
			s += A[i];
		}
		return s;
	}

	public long solve(int ik, int b) {
		long sum = 0;
		for (int a : A[b]) {
			sum += D[ik - 1][a];
		}
		return sum;
	}

	public long solve() {
		Arrays.fill(D[0], 1);
		for (int ik = 1; ik < k; ik++) {
			for (int b = 1; b <= n; b++) {
				D[ik][b] = solve(ik, b) % PRIME;
			}
		}
		return sum(D[k - 1], 1, n) % PRIME;
	}

	public static Bravo load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		assert 1 <= n && n <= 2000 : "out of range, n: " + n;
		assert 1 <= k && k <= 2000 : "out of range, k: " + k;
		return new Bravo(n, k);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println(o.solve());
	}

}
