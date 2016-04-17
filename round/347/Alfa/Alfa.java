import java.util.*;
import java.io.*;
import java.math.BigInteger;

/* Mighty Cohadar */
public class Alfa {

	static BigInteger gcd(BigInteger a, BigInteger b) {
		return (BigInteger.ZERO.compareTo(b) == 0) ? a : gcd(b, a.mod(b));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] S = scanner.nextLine().split(" ");
		BigInteger a = new BigInteger(S[0], 10);
		BigInteger b = new BigInteger(S[1], 10);
		
		BigInteger g = gcd(a, b);
		debug(a, b, g);
		while (a.compareTo(b) != 0) {
			a = a.add(BigInteger.ONE);
			g = gcd(g, a);
			if (BigInteger.ONE.compareTo(g) == 0) {
				break;
			}
		}
		System.out.println(g);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

