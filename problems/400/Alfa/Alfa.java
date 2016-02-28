import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	static class Pair implements Comparable<Pair> {
		final int x;
		final int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair that) {
			if (this.x == that.x) {
				return Integer.compare(this.y, that.y);
			} else {
				return Integer.compare(this.x, that.x);
			}
		}
		public String toString() {
			return String.format("%dx%d", x, y);
		}	
	}

	final char[] C;
	
	public Alfa(char[] C) {
		this.C = C;
	}

	public boolean win(int a, int b) {
		for (int ib = 0; ib < b; ib++) {
			boolean win = true;
			for (int ia = 0; ia < a; ia++) {
				if ('O' == C[ia * b + ib]) {
					win = false;
					break;
				}
			}
			if (win) {
				return true;
			}
		}
		return false;
	}

	public List<Pair> solve(List<Pair> P) {
		List<Pair> L = new ArrayList<Pair>();
		for (Pair p : P) {
			if (win(p.x, p.y)) {
				L.add(p);
			}
		}
		return L;
	}

	public static Alfa load(Scanner scanner) {
		char[] C = scanner.nextLine().toCharArray();
		assert C.length == 12;
		return new Alfa(C);
	}	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Pair> P = new ArrayList<Pair>();
		P.add(new Pair(1, 12));
		P.add(new Pair(2, 6));
		P.add(new Pair(3, 4));
		P.add(new Pair(4, 3));
		P.add(new Pair(6, 2));
		P.add(new Pair(12, 1));
		int t = Integer.valueOf(scanner.nextLine());
		assert 1 <= t && t <= 100 : "out of range, t: " + t;
		while (t-->0) {
			Alfa o = Alfa.load(scanner);
			System.out.println(toString(o.solve(P)));
		}
	}

	static String join(List<Pair> A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (Pair a : A) {
			sb.append(a);
			sb.append(delimiter);
		}
		if (sb.length() >= delimiter.length()) {
			sb.setLength(sb.length() - delimiter.length());
		}			
		return sb.toString();
	}

	public static String toString(List<Pair> L) {
		return String.format("%d %s", L.size(), join(L, " "));
	}

}
