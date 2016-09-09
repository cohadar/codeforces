import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		boolean found = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			if (found) {
				sb.append(s);	
				sb.append('\n');	
			} else {
				if (s.contains("OO")) {
					sb.append(s.replaceFirst("OO", "++"));	
					sb.append('\n');	
					found = true;
				} else {
					sb.append(s);	
					sb.append('\n');	
				}
			}
		}
		if (found) {
			System.out.println("YES");
			System.out.print(sb);
		} else {
			System.out.println("NO");
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

