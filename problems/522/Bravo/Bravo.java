import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 2 <= n && n <= 2e5 : "out of range, n: " + n;
		int[] W = new int[n];
		int[] H = new int[n];
		int sumW = 0;
		int maxH1 = -1;
		int maxH2 = -1;
		for (int i = 0; i < n; i++) {
			W[i] = scanner.nextInt();
			H[i] = scanner.nextInt();
			sumW += W[i];
			if (maxH1 <= H[i]) {
				maxH2 = maxH1;
				maxH1 = H[i];
			} else if (maxH2 < H[i]) {
				maxH2 = H[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int width = sumW - W[i];
			int height = (H[i] == maxH1) ? maxH2 : maxH1; 
			sb.append(height * width);
			sb.append(' ');
		}
		System.out.println(sb);
	}


}

