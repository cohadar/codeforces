import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a = scanner.nextInt() - 1;
		int b = scanner.nextInt();
		int k = (n + a + b) % n;
		System.out.println(k + 1);
	}
	
}

