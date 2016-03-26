import java.util.*;
import java.io.*;
import javafx.geometry.Point2D;

/* Mighty Cohadar */
public class Alfa {

	static class Line {
		final double a;
		final double b;
		final double c;
		Line(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public String toString() {
			return String.format("(a=%f, b=%f, c=%f)", a, b, c);
		}	
	}

	public static double plug(Line l, Point2D p) {
		return l.a * p.getX() + l.b * p.getY() + l.c;
	}

	public static boolean oppositeSides(Line l, Point2D a, Point2D b) {
		return plug(l, a) * plug(l, b) < 0.0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Point2D home = new Point2D(scanner.nextDouble(), scanner.nextDouble());
		Point2D univ = new Point2D(scanner.nextDouble(), scanner.nextDouble());
		int n = scanner.nextInt();
		assert 1 <= n && n <= 300 : "out of range, n: " + n;
		Line[] L = new Line[n];
		for (int i = 0; i < n; i++) {
			L[i] = new Line(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
		}
		int count = 0;
		for (Line l : L) {
			if (oppositeSides(l, home, univ)) {
				count++;
			}
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

