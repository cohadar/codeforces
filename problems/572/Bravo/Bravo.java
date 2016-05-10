import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int nn = scanner.nextInt();
		final int ss = scanner.nextInt();
		TreeMap<Integer, Integer> B = new TreeMap<>();
		TreeMap<Integer, Integer> S = new TreeMap<>();
		for (int i = 0; i < nn; i++) {
			char d = scanner.next().charAt(0);
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			TreeMap<Integer, Integer> T = (d == 'B') ? B : S;
			Integer value = T.get(p);
			value = (value == null) ? 0 : value;
			T.put(p, value + q);
		}
		StringBuilder sb = new StringBuilder();
		ArrayDeque<String> Q = new ArrayDeque<>();
		S.entrySet().stream().limit(ss).forEach(s -> Q.addFirst(String.format("S %d %d\n", s.getKey(), s.getValue())));
		Q.forEach(s -> sb.append(s));
		B.descendingMap().entrySet().stream().limit(ss).forEach(s -> sb.append(String.format("B %d %d\n", s.getKey(), s.getValue())));
		System.out.println(sb);
	}

}