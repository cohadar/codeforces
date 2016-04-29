import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		int h = scanner.nextInt();
		int v = scanner.nextInt();
		int e = scanner.nextInt();
		double r = 1.0 * d / 2;
		if (h == 0) {
			System.out.println("YES");
			System.out.println(0.0);
			return;
		}
		double v2 = r * r * Math.PI * e;
		System.out.println((v2 < v) ? "YES" : "NO");
		if (v2 < v) {
			double vt = v - v2;
			double dh = vt / (r * r * Math.PI);
			System.out.println(h / dh);
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}
