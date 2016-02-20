import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	final int n;
	final int[] R;
	final int[] H;
	final double[] V;
	final double[][] D;
	
	public Delta(int[] R, int[] H) {
		assert R.length == H.length : "R.length == H.length";
		this.n = R.length;
		this.R = R;
		this.H = H;
		this.V = new double[n];		
		this.D = new double[n][n];
		for (int i = 0; i < n; i++) {
			V[i] = Math.PI * R[i] * R[i] * H[i];
		}
	}

	public void initD() {
		double max = V[ 0 ];
		for (int i = 0;  i < n; i++) {
			max = Math.max(max, V[i]);
			D[0][i] = max;
		}
	}
	
	public double solve() {
		initD();
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < k; i++) {
				D[k][i] = D[k-1][i];
				if (V[i] < V[k]) {
					double temp = V[k] + D[k-1][k];
					D[k][i] = Math.max(D[k][i], temp);
				}
			}
		}
		double max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, D[n-1][i]);
		
		}
		return max;
	}

	public static Delta load(Scanner scanner) {
		int n = scanner.nextInt();
		assert 1 <= n && n <= 100_000 : "out of range, n: " + n;
		int[] R = new int[n];
		int[] H = new int[n];
		for (int i = 0; i < n; i++) {
			R[i] = scanner.nextInt();
			H[i] = scanner.nextInt();
			assert 1 <= R[i] && R[i] <= 10_000 : "out of range, R[i]: " + R[i];
			assert 1 <= H[i] && H[i] <= 10_000 : "out of range, H[i]: " + H[i];
		}
		return new Delta(R, H);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Delta o = Delta.load(scanner);
		System.out.println(o.solve());
	}

}
