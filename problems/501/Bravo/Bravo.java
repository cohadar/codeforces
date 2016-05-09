import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Map<String, String> AB = new HashMap<>();
		Map<String, String> BA = new HashMap<>();
		outer:
		for (int i = 0; i < n; i++) {
			String[] S = scanner.nextLine().split(" ");
			String a = BA.remove(S[0]);
			if (a == null) {
				AB.put(S[0], S[1]);
				BA.put(S[1], S[0]);
			} else {
				AB.put(a, S[1]);
				BA.put(S[1], a);
			}
		}
		System.out.println(AB.size());
		AB.forEach((x, y) -> System.out.println(x + " " + y));
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}
