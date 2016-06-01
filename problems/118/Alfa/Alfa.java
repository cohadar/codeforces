import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		s = s.replaceAll("[aeiyouAEIYOU]", "").toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append('.');
			sb.append(c);
		}
		System.out.println(sb);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

