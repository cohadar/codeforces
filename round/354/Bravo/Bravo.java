import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	static final int[] T = new int[] {0, 1, 3, 6, 10, 15, 21, 28, 36, 45};

	static final Map<Integer, Integer> L = new HashMap<>();
	static final Map<Integer, Integer> R = new HashMap<>();

	// 1 to 10
	public static int height(int x) {
		int h = 0;
		for (int i = 0; i < T.length; i++) {
			if (x >= T[i]) {
				h++;
			}
		}
		return h;
	}

	public static void pour(int[] A, int index, int volume) {
		if (index >= A.length) {
			return;
		}
		A[index] += volume;
		if (A[index] > 1024) {
			int spillover = (A[index] - 1024) / 2;
			A[index] = 1024;
			pour(A, L.get(index), spillover);
			pour(A, R.get(index), spillover);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		for (int i = 0; i < 10 * (10+1) / 2; i++) {
			int h = height(i);
			L.put(i, i + h);
			R.put(i, i + h + 1);
		}
		if (t >= 2000) {
			System.out.println(n * (n+1) / 2);
			return;
		}
		int[] A = new int[n * (n+1) / 2];
		for (int i = 0; i < t; i++) {
			pour(A, 0, 1024);
		}
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1024) {
				count++;
			}
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

