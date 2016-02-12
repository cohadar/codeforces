import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long k = scanner.nextLong();
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long ap = a / k + ((a % k > 0) ? 1 : 0);
		long bp = b / k + ((b % k < 0) ? -1 : 0);
		System.out.println(bp - ap + 1);
	}

}

