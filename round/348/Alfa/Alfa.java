import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e9 : "out of range, n: " + n;
		System.out.println(n / 3 * 2 + ((n % 3 == 0) ? 0 : 1));
	}
	
}

