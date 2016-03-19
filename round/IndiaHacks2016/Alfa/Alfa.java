import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	public static boolean ok(int a, int b, int c) {
		return b == a + 1 && c == b + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert n >= 3;
		TreeSet<Integer> T = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			T.add(scanner.nextInt());
		}
		int a = -1;
		int b = T.pollFirst();
		int c = T.pollFirst();
		while (!T.isEmpty()) {
			a = b;
			b = c;
			c = T.pollFirst();
			if (ok(a, b, c)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
