import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		TreeSet<Character> Q = new TreeSet<>();
		for (int i = 0; i < C.length; i++) {
			if ('a' <= C[i] && C[i] <= 'z') {
				Q.add(C[i]);
			}
		}
		System.out.println(Q.size());
	}

}

