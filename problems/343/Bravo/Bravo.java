import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static boolean solve(char[] C) {
		assert C.length > 0;
		if (C.length % 2 != 0) {
			return false;
		}
		Deque<Character> Q = new ArrayDeque<>();
		for (int i = 0; i < C.length; i++) {
			if (Q.isEmpty() == false && Q.peekFirst() == C[i]) {
				Q.removeFirst();	
			} else {
				Q.addFirst(C[i]);
			}
		}
		return Q.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		System.out.println((solve(C)) ? "Yes" : "No");
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

