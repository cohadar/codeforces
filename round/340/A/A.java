import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int steps = 0;
		for (int i = 5; i >= 1; i--) {
			int temp = n / i;
			steps += temp;
			n -= temp * i;
			if (n == 0) {
				break;
			}
		}
		System.out.println(steps);
	}

}
