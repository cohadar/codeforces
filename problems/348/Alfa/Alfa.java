import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 3 <= n && n <= 1e5 : "out of range, n: " + n;
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			assert 1 <= a && a <= 1e9 : "out of range, a: " + a;
			A[i] = a;
		}
		Arrays.sort(A);
		int games = 0;
		while (A[n - 1] > games) {
			A[0]++;
			games++;
			for (int i = 0; i < n - 1; i++) {
				if (A[i] > A[i + 1]) {
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
				} else {
					break;
				}
			}
		}
		System.out.println(games);
	}

}

