import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final int n;
	final char[] C;
	final TreeSet<String> T;
	final boolean[][] D;
	
	public Charlie(char[] C) {
		this.n = C.length;
		this.C = C;
		this.T = new TreeSet<String>();
		this.D = new boolean[2][n+5];
	}

	public int dirac(boolean b) {
		return (b) ? 1 : 0;
	}

	public void rec(int k, String prev) {
		if (D[dirac(prev.length()==2)][k]) {
			return;
		}
		if (k >= 2) {
			if (prev.length() == 3 || C[k-2] != prev.charAt(0) || C[k-1] != prev.charAt(1)) {
				String s = ""+C[k-2]+C[k-1];
				T.add(s);
				rec(k-2, s);
			}
		}
		if (k >= 3) {
			if (prev.length() == 2 || C[k-3] != prev.charAt(0) || C[k-2] != prev.charAt(1) || C[k-1] != prev.charAt(2)) {
				String s = ""+C[k-3]+C[k-2]+C[k-1];
				T.add(s);
				rec(k-3, s);
			}			
		}
		D[dirac(prev.length()==2)][k] = true;
	}

	public TreeSet<String> solve() {
		rec(n, "@@@");
		rec(n, "@@");
		return T;
	}

	public static Charlie load(Scanner scanner) {
		String line = scanner.nextLine();
		char[] C = line.substring(5).toCharArray();
		return new Charlie(C);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Charlie o = Charlie.load(scanner);
		TreeSet<String> S = o.solve();
		System.out.println(S.size());
		for (String s : S) {
			System.out.println(s);
		}
	}

}
