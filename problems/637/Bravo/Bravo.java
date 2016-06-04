import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Deque<String> Q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			Q.push(s);
		}
		Set<String> S = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (String s : Q) {
			if (!S.contains(s)) {
				S.add(s);
				sb.append(s);
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

