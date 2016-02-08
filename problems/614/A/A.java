import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long l = scanner.nextLong();
		long r = scanner.nextLong();
		long k = scanner.nextLong();
		StringBuilder sb = new StringBuilder();
		long p = 1;
		while (true) {
			if (l <= p && p <= r) {
				sb.append(p);
				sb.append(' ');
			}
			long prev = p;
			try {
				p = Math.multiplyExact(p, k);
			} catch (ArithmeticException e) {
				break;
			}
			if (p > r) {
				break;
			}
		}
		if (sb.length() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(sb);
		}
	}

}