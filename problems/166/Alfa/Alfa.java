import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 50 : "out of range, n: " + n;
		int k = scanner.nextInt();
		assert 1 <= k && k <= n : "out of range, k: " + k;
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			int p = scanner.nextInt();
			int t = scanner.nextInt();
			assert 1 <= p && p <= 50 : "out of range, p: " + p;
			assert 1 <= t && t <= 50 : "out of range, t: " + t;
			A[i] = p * -1000 + t; 
		}
		Arrays.sort(A);
		int[] P = new int[n];
		int place = 1;
		int prev = A[0];		
		for (int i = 0; i < A.length; i++) {
			if (A[i] != prev) {
				place++;
			}
			P[i] = place;
			prev = A[i];
		}
		int count = 0;
		for (int i = 0; i < P.length; i++) {
			if (P[i] == P[k - 1]) {
				count++;
			}
		}
		System.out.println(count);
	}

}

