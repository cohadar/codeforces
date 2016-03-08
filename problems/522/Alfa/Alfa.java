import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 200 : "out of range, n: " + n;
		scanner.nextLine();
		Map<String, Integer> M = new HashMap<>();
		M.put("polycarp", 1);
		int max = 1;
		for (int i = 0; i < n; i++) {
			String a = scanner.next().toLowerCase();
			String r = scanner.next();
			assert "reposted".equals(r);
			String b = scanner.next().toLowerCase();
			int count = M.get(b) + 1;
			if (max < count) {
				max = count;
			}
			M.put(a, count);
		}
		System.out.println(max);
	}

}

