import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class C {

	final int n;
	final int k;
	int sum;
	int[][] D;
	
	public C (int n, int k) {
		this.n = n;
		this.k = k;
		this.D = new int[n][n];
	}

	public void solve() {	
		int curr = n * n;
		for (int y = n - 1; y >= 0; y--) {
			for (int x = n - 1; x >= k - 1; x--) {
				D[y][x] = curr--;
			}
		}
		curr = 1;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < k - 1; x++) {
				D[y][x] = curr++;
			}
		}
		sum = 0;
		for (int y = 0; y < n; y++) {
			sum += D[y][k - 1];
		}
	}

	public static C load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		assert 1 <= n && n <= 500 : "out of range, n: " + n;
		assert 1 <= k && k <= n : "out of range, k: " + k;
		return new C(n, k);
	}	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		C o = C.load(scanner);
		o.solve();
		System.out.println(o.sum);
		printMatrix(o.D);
	}

	static void printMatrix(int[][] D) {
		int n = D.length;
		for (int y = 0; y < n; y++) {
			System.out.println(join(D[y], ' '));
		}
	}

	static String join(int[] A, char delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int o : A) {
			sb.append(o);
			sb.append(delimiter);
		}
		return sb.toString();
	}

}
