import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long c = scanner.nextLong();
		long litres = 0;
		if (a <= b - c) {
			litres = n / a;
		} else {
			litres = Math.max(0, n - c) / (b - c);
			n -= litres * (b - c);
			litres += n / Math.min(a, b);
		}
		System.out.println(litres);
	}

}

