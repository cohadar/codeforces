import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		char[] C = scanner.nextLine().toCharArray();
		if (C.length > 26) {
			System.out.println(-1);
			return;
		}
		Set<Character> S = new HashSet<>();
		int num = 0;
		for (char c : C) {
			if (S.add(c) == false) {
				num++;
			}
		}
		System.out.println(num);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

