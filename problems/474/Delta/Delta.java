import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Delta {

	static final int PRIME = (int)1e9 + 7;

	final int k;
	final int[] C = new int[100_001];
	final int[] D = new int[100_001];
	
	public Delta(int k) {
		this.k = k;
	}

	public void solve() {
		D[0] = 1; // trick
		int cumul = 0;
		for (int x = 1; x < k; x++) {
			D[x] = 1;
			cumul += 1;
			C[x] = cumul;
		}
		for (int x = k; x < D.length; x++) {
			D[x] = D[x - 1] + D[x - k];
			D[x] %= PRIME;
			cumul += D[x];
			cumul %= PRIME;
			C[x] = cumul;
		}
	}

	public int query(int a, int b) {
		int ret = C[b] - C[a - 1];
		if (ret < 0) {
			ret += PRIME;
		}
		return ret;
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		assert 1 <= t && t <= 1e5 : "out of range, t: " + t;
		int k = scanner.nextInt();
		assert 1 <= k && k <= 1e5 : "out of range, k: " + k;
		Delta o = new Delta(k);
		o.solve();
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			assert 1 <= a && a <= 1e5 : "out of range, a: " + a;
			assert 1 <= b && b <= 1e5 : "out of range, b: " + b;
			assert a <= b;
			sb.append(o.query(a, b));
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
