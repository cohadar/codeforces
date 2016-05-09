import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int c = scanner.nextInt();
		int l = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			if (x > t) {
				l = 0;
			} else {
				l++;
				if (l >= c) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

