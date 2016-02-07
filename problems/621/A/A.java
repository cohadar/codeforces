import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long sum = 0;
		long min_odd = Long.MAX_VALUE;
		int num_odd = 0;
		for (int i = 0; i < n; i++) {
			long x = scanner.nextLong();
			sum += x;
			if (x % 2 != 0) {
				num_odd++;
				if (min_odd > x) {
					min_odd = x;
				}
			}
		}
		if (num_odd % 2 != 0) {
			sum -= min_odd;
		}
		System.out.println(sum);
	}

}

