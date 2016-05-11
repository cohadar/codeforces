import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int vv = scanner.nextInt();
		int[] D = new int[10];
		for (int i = 1; i <= 9; i++) {
			D[i] = scanner.nextInt();
		}
		int cheap = 1;
		for (int i = 1; i <= 9; i++) {
			if (D[cheap] >= D[i]) {
				cheap = i;
			}
		}
		if (D[cheap] > vv) {
			System.out.println(-1);
			return;
		}
		int n = vv / D[cheap];
		int left = vv - n * D[cheap];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int best = 0;
			for (int d = 1; d <= 9; d++) {
				if (D[d] <= left + D[cheap]) {
					best = d;
				}
			}
			if (best == 0) {
				sb.append(cheap);
			} else {
				sb.append(best);
				left += D[cheap] - D[best];
			}
		}
		System.out.println(sb);
	}
	
}

