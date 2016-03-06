import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	final int n;
	final int[] A; // 1-based
	final int[] E;
	final int[] R;
	
	public Alfa(int n, int[] A) {
		this.n = n;
		this.A = A;
		this.E = new int[A.length];
		this.R = new int[A.length];
	}

	public int getA(int j, int i) {
		return (i == j) ? A[i - 1] + 1 : A[i];
	}

	public int solve() {
		int max = 1;
		E[1] = 1;
		R[1] = 1;
		for (int k = 2; k <= n; k++) {
			E[k] = (condition) ? "YES" : "NO"
		}
		return max;
	}

	public static Alfa load(Scanner scanner) {
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		scanner.nextLine();
		int[] A = new int[1 + n];
		for (int i = 1; i <= n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
		}
		return new Alfa(n, A);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Alfa o = Alfa.load(scanner);
		System.out.println(o.solve());
	}



	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
}
