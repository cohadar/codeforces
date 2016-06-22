import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static int[] minMaxSum(int bits, int[] C) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < C.length; i++) {
			if ((bits & (1 << i)) != 0) {
				min = Math.min(min, C[i]);
				max = Math.max(max, C[i]);
				sum += C[i];
			}
		}
		return new int[] {min, max, sum};
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int l = scanner.nextInt();
		int r = scanner.nextInt();
		int x = scanner.nextInt();
		int[] C = new int[n];
		for (int i = 0; i < C.length; i++) {
			C[i] = scanner.nextInt();
		}
		int count = 0;
		for (int bits = 0; bits < (1 << n); bits++) {
			if (Integer.bitCount(bits) >= 2) {
				int[] minMaxSum = minMaxSum(bits, C);
				int min = minMaxSum[0];
				int max = minMaxSum[1];
				int sum = minMaxSum[2];
				if (l <= sum && sum <= r && max - min >= x) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}

