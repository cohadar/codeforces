import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Delta {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int na = scanner.nextInt();
		int nb = scanner.nextInt();
		int kk = scanner.nextInt();
		int[][][] D = new int[na][nb][1 + kk];
		scanner.nextLine();
		char[] A = scanner.nextLine().toCharArray();
		char[] B = scanner.nextLine().toCharArray();
		for (int c = 1; c <= kk; c++) {
			for (int a = 0; a < na; a++) {
				D[a][0][c] = -INF;	
			}
			for (int b = 0; b < nb; b++) {
				D[0][b][c] = -INF;		
			}
		}
		int max = 0;
		for (int a = 1; a < na; a++) {
			for (int b = 1; b < nb; b++) {
				for (int k = 1; k <= kk; k++) {
					D[a][b][k] = -INF;
					if (A[a] == B[b]) {
						D[a][b][k] = Math.max(1 + D[a-1][b-1][k], 1 + D[a-1][b-1][k-1]);
					}
					D[a][b][k] = Math.max(D[a][b][k], D[a-1][b][k-1]);
					D[a][b][k] = Math.max(D[a][b][k], D[a][b-1][k-1]);
					max = Math.max(max, D[a][b][k]);
				}
			}
		}
		System.out.println(max);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

