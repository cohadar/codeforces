import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	static final int INF = Integer.MAX_VALUE / 2;

	static int vl;
	static int vr;
	static int d;

	static int[][] D = new int[200][2000];

	public static int rec(int t, int v) {
		if (t == 0) {
			if (Math.abs(v - vl) <= d) {
				return vl;
			} else {
				return -INF;
			}
		}
		if (D[t][v] != 0) {
			return D[t][v];
		}
		int max = -INF;
		for (int i = v - d; i <= v + d; i++) {
			if (i > 0) {
				int temp = i + rec(t - 1, i);
				if (max < temp) {
					max = temp;
				}
			}
		}
		return D[t][v] = max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		vl = scanner.nextInt();
		vr = scanner.nextInt();
		assert 1 <= vl && vl <= 100 : "out of range, vl: " + vl;
		assert 1 <= vr && vr <= 100 : "out of range, vr: " + vr;
		int t = scanner.nextInt();
		assert 2 <= t && t <= 100 : "out of range, t: " + t;
		d = scanner.nextInt();
		assert 0 <= d && d <= 10 : "out of range, d: " + d;
		System.out.println(vr + rec(t - 2, vr));
	}

}

