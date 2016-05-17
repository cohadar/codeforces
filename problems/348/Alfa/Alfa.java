import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		NavigableSet<Integer> S = new TreeSet<>();
		int[] A = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			S.add(A[i]);
			sum += A[i];
		}
		long rounds = 0;
		long sum2 = 0;
		while (sum > sum2) {
			int a = S.pollFirst();
			int b = S.first();
			int d = b - a + 1;
			S.add(a + d);
			sum2 += (n - 1L) * d;
			rounds += d;
		}
		int d = (int)(sum2 - sum);
		int max = 0;
		for (int s : S) {
			max = Math.max(max, s - d);
		}
		System.out.println(rounds + max);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

