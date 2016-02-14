import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] D = new int[m];
		int[] H = new int[m];
		for (int i = 0; i < m; i++) {
			D[i] = scanner.nextInt() - 1;
			H[i] = scanner.nextInt();
		}
		int max = 0;
		max = Math.max(max, H[0] + D[0]);
		max = Math.max(max, H[m - 1] + n - 1 - D[m - 1]);
		for (int i = 1; i < m; i++) {
			if (Math.abs(H[i] - H[i - 1]) > D[i] - D[i - 1]) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			int h2 = (D[i] - D[i - 1]) + H[i - 1] + H[i];
			max = Math.max(max, h2 / 2);
		}
		System.out.println(max);
	}

}

