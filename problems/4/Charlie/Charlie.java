import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Charlie {

	public static boolean add(Map<String, Integer> M, String key) {
		Integer count = M.get(key);
		if (count == null) {
			M.put(key, 1);	
			return true;
		} else {
			M.put(key, count + 1);
			return false;
		}
	}
	
	public static boolean remove(Map<String, Integer> M, String key) {
		Integer count = M.get(key);
		if (count == null) {
			return false;
		}
		count--;
		if (count == 0) {
			M.remove(key);
		} else {
			M.put(key, count);
		}
		return true;
	}
	
	public static int count(Map<String, Integer> M, String key) {
		Integer count = M.get(key);
		return (count == null) ? 0 : count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Map<String, Integer> M = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			add(M, s);
			int c = count(M, s);
			if (c == 1) {
				System.out.println("OK");
			} else {
				System.out.println(s + (c - 1));
			}
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

