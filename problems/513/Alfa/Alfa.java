import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	final int k1;
	final int k2;
	final Boolean[][] FC = new Boolean[51][51];
	final Boolean[][] SC = new Boolean[51][51];
	
	public Alfa(int k1, int k2) {
		this.k1 = k1;
		this.k2 = k2;
	}

	public boolean second(int n1, int n2) {
		if (SC[n1][n2] != null) {
			return SC[n1][n2];
		}		
		if (n2 == 0) {
			return false;
		}
		for (int i = 1; i <= k2 && i <= n2; i++) {
			if (!first(n1, n2 - i)) {
				SC[n1][n2] = true;
				return true;
			}
		}
		SC[n1][n2] = false;
		return false;
	}
	
	public boolean first(int n1, int n2) {
		if (FC[n1][n2] != null) {
			return FC[n1][n2];
		}
		if (n1 == 0) {
			return false;
		}
		for (int i = 1; i <= k1 && i <= n1; i++) {
			if (!second(n1 - i, n2)) {
				FC[n1][n2] = true;
				return true;
			}
		}
		FC[n1][n2] = false;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int k1 = scanner.nextInt();
		int k2 = scanner.nextInt();
		Alfa a = new Alfa(k1, k2);
		System.out.println((a.first(n1, n2)) ? "First" : "Second");
	}

}

