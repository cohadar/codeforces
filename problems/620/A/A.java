import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long x1 = scanner.nextInt();
		long y1 = scanner.nextInt();
		long x2 = scanner.nextInt();
		long y2 = scanner.nextInt();
		System.out.println(Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)));
	}

}

