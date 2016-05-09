import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;
		for (int i = 0; i < n; i++) {
			sum1 += scanner.nextInt();
		}
		for (int i = 1; i < n; i++) {
			sum2 += scanner.nextInt();
		}
		for (int i = 2; i < n; i++) {
			sum3 += scanner.nextInt();
		}
		System.out.println(sum1 - sum2);
		System.out.println(sum2 - sum3);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

