import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static boolean solve(List<Integer> A, List<Integer> B) {
		for (Integer a : A) {
			for (Integer b : B) {
				if (Math.abs(a - b) >= 2) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		for (int i = 0; i < C.length - 1; i++) {
			if (C[i] == 'A' && C[i+1] == 'B') {
				A.add(i);
			}
			if (C[i] == 'B' && C[i+1] == 'A') { 
				B.add(i);
			}
		}
		System.out.println((solve(A, B)) ? "YES" : "NO");
	}

}

