import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n == 1) {
			System.out.println("-1");
			return;
		}
		int dx = 0;
		int dy = 0;
		int ax = scanner.nextInt();
		int ay = scanner.nextInt();
		for (int i = 1; i < n; i++) {
			int bx = scanner.nextInt();
			int by = scanner.nextInt();
			dx = Math.max(dx, Math.abs(ax - bx));
			dy = Math.max(dy, Math.abs(ay - by));
			ax = bx;
			ay = by;
		}
		int area = dx * dy;
		System.out.println((area == 0) ? -1 : area);
	}

}

