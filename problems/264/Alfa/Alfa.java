import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> L = new LinkedList<>();
		ListIterator<Integer> l = L.listIterator();
		int i = 1;
		for (char c : scanner.nextLine().toCharArray()) {
			l.add(i++);
			if (c == 'l') {
				l.previous();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j : L) {
			sb.append(j);
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
