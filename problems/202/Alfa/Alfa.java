import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		String best = "";
		for (int bits = 1; bits < (1 << C.length); bits++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C.length; i++) {
				if ((bits & (1 << i)) != 0) {
					sb.append(C[i]);
				}
			}
			String a = new String(sb);
			sb.reverse();
			String b = new String(sb);
			if (a.equals(b) && a.compareTo(best) > 0) {
				best = a;
			}
		}
		System.out.println(best);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

