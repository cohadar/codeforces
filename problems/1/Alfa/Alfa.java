import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int a = scanner.nextInt();
		long x = (long)Math.ceil(n * 1.0 / a);
		long y = (long)Math.ceil(m * 1.0 / a);
		System.out.println(x * y);
	}

}

