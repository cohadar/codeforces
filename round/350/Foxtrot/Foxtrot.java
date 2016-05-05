import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Foxtrot {

	public static boolean allZero(int[] D) {
		for (int i = 1; i < D.length; i++) {
			if (D[i] > 0) {
				return false;
			}
		}
		return true;
	}

	public static int minNonZero(int[] D) {
		for (int i = 1; i < D.length; i++) {
			if (D[i] > 0) {
				return i;
			}
		}
		assert false : "snh";
		return -1;
	}

	// append(sb, D, i);
	public static void append(StringBuilder sb, int[] D, int i) {
		for (int j = 0; j < D[i]; j++) {
			sb.append(i);
		}
	}

	public static String first(String b, int[] D) {
		StringBuilder sb = new StringBuilder();
		sb.append(b);
		for (int i = 0; i < D.length; i++) {
			append(sb, D, i);
		}
		return sb.toString();
	}

	public static String second(String b, int[] D, char[] B, boolean rising) {
		StringBuilder sb = new StringBuilder();
		int mnz = minNonZero(D);
		D[mnz]--;
		sb.append(mnz);
		for (int i = 0; i < B[0] - '0'; i++) {
			append(sb, D, i);
		}
		if (rising) {
			append(sb, D, B[0] - '0');
			sb.append(b);			
		} else {
			sb.append(b);
			append(sb, D, B[0] - '0');
		}
		for (int i = B[0] - '0' + 1; i < D.length; i++) {
			append(sb, D, i);
		}		
		D[mnz]++;
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		if ("0".equals(a) || "1".equals(a)) {
			System.out.println(0);
			return;
		}
		int l = A.length;
		int d = Math.max(1, l - 10);
		while (d <= l) {
			if (d + String.valueOf(d).length() == l) {
				break;
			} else {
				d++;
			}
		}
		int[] D = new int[10];
		for (int i = 0; i < A.length; i++) {
			D[A[i] - '0']++;
		}
		for (int i = 0; i < B.length; i++) {
			D[B[i] - '0']--;
		}
		for (char c : String.valueOf(d).toCharArray()) {
			D[c - '0']--;	
		}
		for (int i = 0; i < D.length; i++) {
			assert D[i] >= 0;
		}
		if (allZero(D)) {
			System.out.println(first(b, D));
			return;
		} 
		String aa = first(b, D);
		String bb = second(b, D, B, false);
		String cc = second(b, D, B, true);
		if (aa.charAt(0) == '0' || aa.compareTo(cc) >= 0) {
			aa = cc;
		}
		if (bb.compareTo(aa) <= 0) {
			System.out.println(bb);
		} else {
			System.out.println(aa);
		}
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

