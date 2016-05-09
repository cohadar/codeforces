import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static void pwd(ArrayDeque<String> Q) {
		for (String s : Q) {
			System.out.print('/' + s);
		}
		System.out.println('/');
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		ArrayDeque<String> Q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			if ("pwd".equals(s)) {
				pwd(Q);
			} else {
				String[] s2 = s.split(" ");
				assert "cd".equals(s2[0]);
				if (s2[1].startsWith("/")) {
					Q.clear();
				}
				String[] dirs = s2[1].split("/");
				for (String dir : dirs) {
					if ("..".equals(dir)) {
						Q.removeLast();
					} else if ("".equals(dir) == false) {
						Q.addLast(dir);
					}
				}
			}
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

