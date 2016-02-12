import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int min_x = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;
		int min_y = Integer.MAX_VALUE;
		int max_y = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			min_x = Math.min(min_x, x);
			max_x = Math.max(max_x, x);
			min_y = Math.min(min_y, y);
			max_y = Math.max(max_y, y);
		}
		int area = (max_x - min_x) * (max_y - min_y);
		System.out.println((area == 0) ? -1 : area);
	}

}

