import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		TreeMap<Integer, Integer> M = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			assert 1 <= a && a <= 1e5 : "out of range, a: " + a;
			Integer count = M.get(a);
			M.put(a, 1 + ((count==null) ? 0 : count));
		}
		int[] A = new int[n];
		int[] C = new int[n];
		long[] D = new long[n];
		n = M.size();
		int i = 0;
		for (Map.Entry<Integer, Integer> e : M.entrySet()) {
			A[i] = e.getKey();
			C[i] = e.getValue();
			i++;
		}
		D[0] = (long)A[0] * (long)C[0];
		for (int k = 1; k < n; k++) {
			D[k] = D[k-1];
			int l = k-1;
			if (A[l] == A[k]-1) {
				l--;
			}
			long dl = (l < 0) ? 0 : D[l];
			D[k] = Math.max(D[k], (long)A[k] * (long)C[k] + dl);
		}
		System.out.println(D[n-1]);
	}

}

