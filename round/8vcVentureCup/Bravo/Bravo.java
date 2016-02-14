import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	final int n;
	final char[] C;

	boolean[] BGR = new boolean[3];
	
	int nb;
	int ng;
	int nr;

	HashSet<String> CACHE = new HashSet<>();

	public Bravo(int n, char[] C) {
		this.n = n;
		this.C = C;
		for (int i = 0; i < C.length; i++) {
			switch (C[i]) {
			case 'B':
				nb++;
				break;
			case 'G':
				ng++;
				break;
			case 'R':
				nr++;
				break;
			}
		}
	}

	public static int[] dec1(int[] bgr, int index) {
		int[] ret = new int[3];
		for (int i = 0; i < 3; i++) {
			ret[i] = bgr[i];
		}
		ret[index]--;
		return ret;
	}

	public static int[] declri(int[] bgr, int l, int r, int index) {
		int[] ret = new int[3];
		for (int i = 0; i < 3; i++) {
			ret[i] = bgr[i];
		}
		ret[l]--;
		ret[r]--;
		ret[index]++;
		return ret;
	}


	public static String key(int b, int g, int r) {
		return String.format("%d.%d.%d", b, g, r);
	}

	static class DoneException extends RuntimeException {};  

	public void rec(int b, int g, int r) {
		if (CACHE.contains(key(b, g, r))) {
			return;
		}
		if (b + g + r == 1) {
			if (b == 1) {
				BGR[0] = true;
			}
			if (g == 1) {
				BGR[1] = true;
			}
			if (r == 1) {
				BGR[2] = true;
			}
			if (BGR[0] && BGR[1] && BGR[2]) {
				throw new DoneException();
			}			
			return;
		}
		if (b >= 2) {
			rec(b-1, g, r);
		}
		if (g >= 2) {
			rec(b, g-1, r);
		}
		if (r >= 2) {
			rec(b, g, r-1);
		}
		if (b > 0 && g > 0) {
			rec(b-1, g-1, r+1);
		}
		if (b > 0 && r > 0) {
			rec(b-1, g+1, r-1);
		}
		if (g > 0 && r > 0) {
			rec(b+1, g-1, r-1);
		}
		CACHE.add(key(b, g, r));
	}

	public String solve() {
		try {
			rec(nb, ng, nr);
		} catch (DoneException e) {
			// nice
		}
		String ret = "";
		for (int i = 0; i < 3; i++) {
			if (BGR[i]) {
				ret += "BGR".charAt(i);
			}
		}
		return ret;
	}

	public static Bravo load(Scanner scanner) {
		int n = Integer.valueOf(scanner.nextLine());
		assert 1 <= n && n <= 200 : "out of range, n: " + n;
		char[] C = scanner.nextLine().toCharArray();
		assert n == C.length;
		return new Bravo(n, C);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println(o.solve());
	}

}
