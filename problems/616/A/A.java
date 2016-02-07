import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static int compare(char[] X, char[] Y) {
		int n = Math.max(X.length, Y.length);
		int ret = 0;
		int x = X.length - 1;
		int y = Y.length - 1;
		for (int i = 0; i < n; i++, x--, y--) {
			char vx = (x < 0) ? '0' : X[x];
			char vy = (y < 0) ? '0' : Y[y];
			int temp = Character.compare(vx, vy);
			if (temp != 0) {
				ret = temp;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] X = scanner.nextLine().toCharArray();
		char[] Y = scanner.nextLine().toCharArray();
		int x = compare(X, Y);
		if (x < 0) {
			System.out.println('<');
		} else if (x > 0) {
			System.out.println('>');
		} else {
			System.out.println('=');
		}
	}

}

