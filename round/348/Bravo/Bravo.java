import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

    final int n;
    final char[] C;
    final int[] A;
    
    public Bravo(int n, char[] C, int[] A) {
    	this.n = n;
    	this.C = C;
    	this.A = A;
    }

	public boolean solve() {
		long pos = 0;
		for (int i = 0; i < 100_000 + 1000; i++) {
			if (pos < 0 || pos >= n) {
				return false;
			}
			if (C[(int)pos] == '<') {
				pos -= A[(int)pos];
			} else {
				pos += A[(int)pos];
			}
		}
		return true;
	}

	public static Bravo load(Scanner scanner) {
		int n = scanner.nextInt();
		assert 1 <= n && n <= 1e5 : "out of range, n: " + n;
		scanner.nextLine();
		char[] C = scanner.nextLine().toCharArray();
		assert C.length == n;
		int[] A = scanArray(scanner, n);
		return new Bravo(n, C, A);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bravo o = Bravo.load(scanner);
		System.out.println((o.solve()) ? "INFINITE" : "FINITE");
	}

	static int[] scanArray(Scanner scanner, int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		return A;
	}

}
