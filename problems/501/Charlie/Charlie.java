import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= (1 << 16) : "out of range, n: " + n;
		int[] D = new int[n];
		int[] X = new int[n];
		for (int i = 0; i < n; i++) {
			D[i] = scanner.nextInt();
			X[i] = scanner.nextInt();
		}
		List<List<Integer>> L = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			L.add(new ArrayList<Integer>());
		}
		Deque<Integer> Q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (D[i] == 1) {
				Q.add(i);
			}
		}
		int nEdges = 0;
		while (!Q.isEmpty()) {
			int a = Q.remove();
			if (D[a] == 1) {
				int b = X[a];
				L.get(a).add(b);
				L.get(b).add(a);
				nEdges++;
				X[a] ^= b;
				X[b] ^= a;
				D[a]--;
				D[b]--;
				if (D[b] == 1) {
					Q.add(b);	
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(nEdges);
		sb.append('\n');
		for (int a = 0; a < n; a++) {
			for (Integer b : L.get(a)) {
				if (a < b) {
					sb.append(a);
					sb.append(' ');
					sb.append(b);
					sb.append('\n');
				}
			}
		}
		System.out.print(sb);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}
