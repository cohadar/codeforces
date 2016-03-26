import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static double max(double... A) {
		double max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
	}

	public static double heronsFormula(double a, double b, double c) {
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
		return (Double.isNaN(area)) ? -1 : area;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		double res = max(heronsFormula(a, b, c), heronsFormula(a, b, d), heronsFormula(a, c, d), heronsFormula(b, c, d));
		if (res > 0.0) {
			System.out.println("TRIANGLE");
		} else if (res == 0.0) {
			System.out.println("SEGMENT");
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
	
}

