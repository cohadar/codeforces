import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final int n;
	final int kk;
	final char[] C;
	
	public Charlie(int n, int k, char[] C) {
		this.n = n;
		this.kk = k;
		this.C = C;
	}

	public int solve0(char c) {
		int run = 0;
		int max_run = 0;
		for (int i = 0; i < n; i++) {
			if (C[i] == c) {
				run++;
			} else {
				run = 0;
			}
			max_run = Math.max(max_run, run);
		}
		return max_run;
	}

	public int solve(char c) {
		if (kk >= n) {
			return n;
		}
		if (kk == 0) {
			return solve0(c);
		}
		int k = kk;
		int l = 0;
		int r = -1;
		for (int i = 0; i < n; i++) {
			if (C[i] == c) {
				r = i;
			} else if (k > 0) {
				k--;
				r = i;
			} else {
				break;
			}
		}
		int max_run = r - l + 1;
		for (int i = r + 1; i < n; i++) {
			if (C[i] == c) {
				r = i;
				max_run = Math.max(max_run, r - l + 1);
			} else {
				while (C[l] == c) {
					l++;
				}
				l++;
				r = i;
			}
		}
		return max_run;
	}

	public static Charlie load(Scanner scanner) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		scanner.nextLine();
		char[] C = scanner.nextLine().toCharArray();
		assert C.length == n;
		return new Charlie(n, k, C);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Charlie o = Charlie.load(scanner);
		System.out.println(Math.max(o.solve('a'), o.solve('b')));
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}
