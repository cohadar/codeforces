import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	public static int solve(int[] P, int[] T, int c) {
		int n = P.length;
		int sum1 = 0;
		int t = 0;
		for (int i = 0; i < n; i++) {
			t += T[i];
			sum1 += Math.max(0, P[i] - c*t);
		}
		int sum2 = 0;
		t = 0;
		for (int i = n - 1; i >= 0; i--) {
			t += T[i];
			sum2 += Math.max(0, P[i] - c*t);
		}
		return sum1 - sum2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 50 : "out of range, n: " + n;
		int c = scanner.nextInt();
		assert 1 <= c && c <= 1000 : "out of range, c: " + c;
		int[] P = scanArray(scanner, n);
		int[] T = scanArray(scanner, n);
		int res = solve(P, T, c);
		if (res == 0) {
			System.out.println("Tie");
		} else if (res > 0) {
			System.out.println("Limak");
		} else {
			System.out.println("Radewoosh");
		}
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}
