import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {
	static class Point2D {
		final double x;
		final double y;
		Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return String.format("(x=%d, y=%d)", x, y);
		}	
	}

	public static double triangleArea(Point2D a, Point2D b, Point2D c) {
		return Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2;
	}

	public static double distanceToSegment(Point2D c, Point2D a, Point2D b) {
		double area = triangleArea(a, b, c);
		double ab = distance(a, b);
		return area * 2 / ab;
	}

	public static double distance(Point2D a, Point2D b) {
		return Math.hypot(a.x - b.x, a.y - b.y);
	}

	public static double circleArea(double r) {
		return r * r * Math.PI;
	}

	static double rmin = Double.MAX_VALUE;
	static double rmax = Double.MIN_VALUE;

	public static void update(Point2D a, Point2D b, Point2D c) {
		double r = distance(c, b);
		if (rmin > r) {
			rmin = r;
		}
		if (rmax < r) {
			rmax = r;
		}
		r = distanceToSegment(c, a, b);
		if (rmin > r) {
			rmin = r;
		}		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 3 <= n && n <= 1e6 : "out of range, n: " + n;
		Point2D c = scanPoint2D(scanner);
		Point2D a = scanPoint2D(scanner);
		Point2D first = a;
		for (int i = 1; i < n; i++) {
			Point2D b = scanPoint2D(scanner);
			update(a, b, c);
			a = b;
		}
		update(a, first, c);
		System.out.println(circleArea(rmax) - circleArea(rmin));
	}

	public static Point2D scanPoint2D(Scanner scanner) {
		int cx = scanner.nextInt();
		int cy = scanner.nextInt();		
		return new Point2D(cx, cy);
	}

}

