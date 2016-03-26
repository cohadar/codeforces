import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	final static int[] dx = new int[] {1, 0, -1,  0};
	final static int[] dy = new int[] {0, 1,  0, -1};

	public static int solve(final int x, final int y) {
		if (x == 0 && y == 0) {
			return 0;			
		}
		int steps = 0;
		int xc = 0;
		int yc = 0;
		for (int k = 0; k <= 10000; k++) {
			steps++;
			int delta = (k + 2) / 2;
			for (int i = 0; i < delta; i++) {
				xc += dx[k % 4];
				yc += dy[k % 4];
				if (xc == x && yc == y) {
					return steps - 1;
				}
			}
		}
		return -666;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		System.out.println(solve(x, y));
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

