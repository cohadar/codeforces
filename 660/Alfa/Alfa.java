import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static boolean coprime(int a, int b) {
		return gcd(a, b) == 1;
	}

	public static int findCoprime(int a, int b) {
		int max = Math.max(a, b);
		for (int i = 1; i < 1000; i++) {
			int k = max - i;
			if (k > 0 && coprime(k, a) && coprime(k, b)) {
				return k;
			}
		}
		int min = Math.min(a, b);
		for (int i = 1; i < 1000; i++) {
			int k = min + i;
			if (k < 1_000_000_000 && coprime(k, a) && coprime(k, b)) {
				return k;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1000 : "out of range, n: " + n;
		int[] A = scanArray(scanner, n);
		List<Integer> L = new ArrayList<>();
		L.add(A[0]);
		for (int i = 1; i < A.length; i++) {
			if (!coprime(A[i-1], A[i])) {
				L.add(findCoprime(A[i-1], A[i]));
			}
			L.add(A[i]);
		}	
		System.out.println(L.size() - A.length);	
		for (int i : L) {
			System.out.print(i);
			System.out.print(' ');
		}
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
			assert 1 <= A[i] && A[i] <= 1e9 : "out of range, A[i]: " + A[i];
		}
		return A;
	}
}
