import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class A {

	public static long solve(long n) {
		long ret = 0;
		ret = n * (n + 1) / 2;
		long p = 1;
		while (p <= n) {
			ret -= 2 * p;
			p *= 2;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		assert 1 <= t && t <= 100 : "out of range, t: " + t;
		while (t-->0) {
			int n = scanner.nextInt();
			System.out.println(solve(n));
		}
	}

}
