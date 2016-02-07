import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		int l = scanner.nextInt();
		int v1 = scanner.nextInt();
		int v2 = scanner.nextInt();
		double res = l - d;
		res /= (v1 + v2);
		System.out.println(res);
	}

}

