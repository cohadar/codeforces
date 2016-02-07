import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	static long liters(long n, long a, long b, long c) {
		if (a <= b - c) {
			return n / a;
		}
		long ret = 0L;
		ret += Math.max(0L, n - b) / (b - c);
		n -= ret * (b - c);
		while (n >= b) {
			ret++;
			n -= (b - c);
		}
		while (n >= a) {
			ret++;
			n -= a;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long c = scanner.nextLong();
		System.out.println(liters(n, a, b, c));
	}

}

