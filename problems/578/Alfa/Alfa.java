import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static double upper(double x0, double y0) {
		long k = (long)((x0 - y0) / (2*y0));
		return (x0 - y0) / (2*k);
	}

	public static double lower(double x0, double y0) {
		long k = (long)((x0 / y0 + 1.0) / 2.0 - 1.0);
		if (k < 0) {
			return Double.POSITIVE_INFINITY;	
		}
		return (x0 + y0) / (2*k + 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double x0 = scanner.nextDouble();
		double y0 = scanner.nextDouble();
		if (y0 > x0) {
			System.out.println(-1);
			return;
		}
		if (x0 == y0) {
			System.out.println(x0);
			return;
		}
		if (y0 == 0.0) {
			System.out.println(x0 / 2);
			return;
		}
		double res = Math.min(upper(x0, y0), lower(x0, y0));
		System.out.println((Double.isInfinite(res)) ? -1 : res);

	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

