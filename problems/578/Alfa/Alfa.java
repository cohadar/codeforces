import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static double upper(double x0, double y0) {
		int kk = -1;
		for (int k = 0; k <= 1_000_000_000; k++) {
			double alpha = (x0 - y0*(2*k+1)) / (x0-y0);
			if (0.0 <= alpha && alpha <= 1.0) {
				
			}
		}
		return 0.0;
	}

	public static double lower(double x0, double y0) {
		return 0.0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double x0 = scanner.nextDouble();
		double y0 = scanner.nextDouble();
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

