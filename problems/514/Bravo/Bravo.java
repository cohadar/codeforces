import java.util.*;
import java.io.*;
import javafx.geometry.Point2D;

/* Mighty Cohadar */
public class Bravo {

	public static boolean colinear(Point2D a, Point2D b, Point2D c) {
		b = b.subtract(a);
		c = c.subtract(a);
		return b.getY() * c.getX() == b.getX() * c.getY();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		Point2D p0 = new Point2D(scanner.nextDouble(), scanner.nextDouble());
		Point2D[] P = new Point2D[n];
		for (int i = 0; i < n; i++) {
			P[i] = new Point2D(scanner.nextDouble(), scanner.nextDouble());
		}
		boolean[] D = new boolean[n];
		int shots = 0;
		for (int i = 0; i < n; i++) {
			if (!D[i]) {
				shots++;
				D[i] = true;
				for (int j = i + 1; j < n; j++) {
					if (colinear(p0, P[i], P[j])) {
						D[j] = true;
					}
				}
			}
		}
		System.out.println(shots);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

