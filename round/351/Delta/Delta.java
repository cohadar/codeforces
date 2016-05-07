import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Delta {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int a = scanner.nextInt()-1;
		int b = scanner.nextInt()-1;
		int c = scanner.nextInt()-1;
		int d = scanner.nextInt()-1;
		if (n == 4 || k < n + 1) {
			System.out.println(-1);
			return;
		}
		boolean[] N = new boolean[n];
		Arrays.fill(N, true);
		N[a] = false;
		N[b] = false;
		N[c] = false;
		N[d] = false;
		int e = 0;
		while (N[e] == false) {
			e++;
		}
		N[e] = false;
		int[] AB = new int[n];
		int[] CD = new int[n];
		AB[0] = a;
		AB[1] = c;
		AB[2] = e;
		AB[3] = d;
		AB[n-1] = b;
		CD[0] = c;
		CD[1] = a;
		CD[2] = e;
		CD[3] = b;
		CD[n-1] = d;
		int j = 4;
		for (int i = 0; i < n; i++) {
			if (N[i] == true) {
				AB[j] = i;
				CD[j] = i;
				j++;
			}
		}
		System.out.println(join(AB, " "));
		System.out.println(join(CD, " "));
 	}

 	static String join(int[] A, String delimiter) {
 		StringBuilder sb = new StringBuilder();
 		for (int a : A) {
 			sb.append(a+1);
 			sb.append(delimiter);
 		}
 		if (sb.length() >= delimiter.length()) {
 			sb.setLength(sb.length() - delimiter.length());
 		}			
 		return sb.toString();
 	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

