import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n % 2 != 0) {
			System.out.println("0");
			return;
		}
		int count = n / 4;
		if (count * 4 == n) {
			count--;
		}
		System.out.println(count);
	}

}

