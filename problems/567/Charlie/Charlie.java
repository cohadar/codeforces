import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static long binom3(long x) {
		if (x < 3) {
			return 0;
		}
		return x * (x - 1) * (x - 2) / 6;
	}

	public static long special(int[] A) {
		HashMap<Integer, Integer> M = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			Integer count = M.get(A[i]);
			M.put(A[i], (count == null) ? 1 : count + 1);
		}
		long count = 0;
		for (int v : M.values()) {
			count += binom3(v);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 2e5 : "out of range, n: " + n;
		int k = scanner.nextInt();
		assert 1 <= k && k <= 2e5 : "out of range, k: " + k;
		int[] A = scanArray(scanner, n);
		if (k == 1) {
			System.out.println(special(A));
			return;
		}
		HashSet<Integer> H = new HashSet<>(); 
		long count = 0;
		for (int il = 0; il < n; il++) {
			int l = A[il];
			if (H.contains(l)) {
				continue;
			} else {
				H.add(l);
			}
			long m = 1L * k * l;
			long r = 1L * k * k * l;
			long l_count = 1;
			long lm_count = 0;
			for (int ir = il + 1; ir < n; ir++) {
				if (A[ir] == r) {
					count += lm_count;
				}
				if (A[ir] == m) {
					lm_count += l_count;
				} 
				if (A[ir] == l) {
					l_count++;
				} 				
			}
		}
		System.out.println(count);
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}
