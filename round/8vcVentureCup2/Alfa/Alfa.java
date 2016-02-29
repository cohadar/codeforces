import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] A = new int[c][r];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			A[y][x] = 1;
		}
		int count = 0;
		for (int y1 = 0; y1 < c; y1++) {
			for (int x1 = 0; x1 < r; x1++) {
				for (int y2 = y1; y2 < c; y2++) {
					for (int x2 = x1; x2 < r; x2++) {
						int temp = 0;
						for (int y = y1; y <= y2; y++) {
							for (int x = x1; x <= x2; x++) {
								if (A[y][x] == 1) {
									temp++;
								} 
							}
						}
						if (temp >= k) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}

