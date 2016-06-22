import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		int x = 0;
		int p = 1;
		for (char c : C) {
			p <<= 1;
			x <<= 1;
			if (c == '7') {
				x++;		
			}	
		}
		System.out.println(p - 1 + x);
	}

}

