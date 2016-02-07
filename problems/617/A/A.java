import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int count = 0;
		for (int s = 5; s >= 1; s--) {
			int temp = x / s;
			count += temp;
			x -= s * temp;
		}
		System.out.println(count);
	}

}

