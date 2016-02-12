import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class A {

	public static boolean pure(String s, int l, int r) {
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) != l) && (s.charAt(i) != r)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		String[] S = new String[n];
		for (int i = 0; i < n; i++) {
			S[i] = scanner.nextLine();
		}
		int max = 0;
		for (int l = 'a'; l <= 'z'; l++) {
			for (int r = l + 1; r <= 'z'; r++) {
				int local = 0;
				for (String s : S) {
					if (pure(s, l, r)) {
						local += s.length();
					}
				}
				max = Math.max(max, local);
			}
		}
		System.out.println(max);
	}

}
