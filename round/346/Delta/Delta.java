import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Delta {

	static enum Direction { E, N, W, S };
	static Direction[] Directions = Direction.values();

	public static boolean isLeftTurn(Direction d, int x0, int y0, int x1, int y1) {
		switch (d) {
		case N:
			return x1 < x0;
		case S:
			return x1 > x0;
		case W:
			return y1 < y0;
		case E:
			return y1 > y0;
		default:
			throw new RuntimeException("Unknown option: " + (d));
		}
	}

	public static Direction left(Direction d) {
		return Directions[(d.ordinal()+1)%4];
	}

	public static Direction reverse(Direction d) {
		return Directions[(d.ordinal()+2)%4];
	}

	public static Direction right(Direction d) {
		return Directions[(d.ordinal()+3)%4];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		int[] X = new int[1+n];
		int[] Y = new int[1+n]; 
		for (int i = 0; i <= n; i++) {
			X[i] = scanner.nextInt();
			Y[i] = scanner.nextInt();
		}
		Direction d = Direction.N;
		int left = 0;
		for (int i = 2; i <= n; i++) {
			if (isLeftTurn(d, X[i-1], Y[i-1], X[i], Y[i])) {
				left++;
				d = left(d);
			} else {
				d = right(d);
			}
		}
		System.out.println(left);
	}

}
