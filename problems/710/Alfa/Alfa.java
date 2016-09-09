import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		int score = 0;
		if ("ah".indexOf(C[0]) >= 0) {
			score++;
		}
		if ("18".indexOf(C[1]) >= 0) {
			score++;
		}
		System.out.println("853".charAt(score));
	}
	
}
