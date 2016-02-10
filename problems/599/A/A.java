import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int ret = Integer.MAX_VALUE;
		ret = Math.min(ret, a + c + b);
		ret = Math.min(ret, 2 * a + 2 * b);
		ret = Math.min(ret, 2 * a + 2 * c);
		ret = Math.min(ret, 2 * b + 2 * c);
		System.out.println(ret);
	}

}

