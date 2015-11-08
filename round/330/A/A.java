import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int l = scanner.nextInt();
				int r = scanner.nextInt();
				if (l == 1 || r == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}

