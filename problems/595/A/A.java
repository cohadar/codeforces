import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 100 : "out of range, n: " + n;
		assert 1 <= m && m <= 100 : "out of range, m: " + m;
		int wake = 0;
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= m; j++) {
				int l = scanner.nextInt();
				int r = scanner.nextInt();
				wake += (l | r);
			}
		}
		System.out.println(wake);
	}

}

