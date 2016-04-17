import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final String aa;
	
	public Charlie(String aa) {
		this.aa = aa;
	}

	public int solve(int[] D, int[] P) {
		int len = aa.length();
		int val = Integer.valueOf(aa);
		int min = D[len];
		int v = min / P[len] * P[len] + val;
		while (v < min) {
			v += P[len];
		}
		return v;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		int[] D = new int[12];
		int[] P = new int[12];
		D[1] = 1989;
		int d = 1;
		for (int i = 2; i < D.length; i++) {
			d *= 10;
			P[i-1] = d;
			D[i] = D[i-1] + d;
		}		
		while (t-->0) {
			Charlie o = new Charlie(scanner.nextLine().substring(4));
			System.out.println(o.solve(D, P));
		}
	}

	public static void test() {
		System.out.println("==========");
		TreeMap<String, Integer> map = new TreeMap<>();
		TreeMap<Integer, String> rmap = new TreeMap<>();
		Integer D[] = new Integer[10];
		for (int year = 1989; year <= 999999999; year++) {
			String v = String.valueOf(year);
			for (int j = v.length() - 1; j >= 0; j--) {
				String abr = v.substring(j);
				if (!map.containsKey(abr)) {
					map.put(abr, year);
					rmap.put(year, abr);
					int len = abr.length();
					if (D[len] == null) {
						D[len] = year;
						debug(len, D[len], abr);
					}
					
					break;
				}
			}
		}
		//debug(rmap);			
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
}
