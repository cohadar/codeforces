import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static boolean isInteger(String s) {
		if (s.length() == 0) {
			return false;
		}
		if ("0".equals(s)) {
			return true;
		}
		if ("123456789".indexOf(s.charAt(0)) < 0) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if ("0123456789".indexOf(s.charAt(i)) < 0) {
				return false;
			}
		}
		return true;
	}

	public static String compact(List<String> a) {
		if (a.size() == 0) {
			return "-";
		}
		return String.format("\"%s\"", join(a, ","));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] C = scanner.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		List<String> a = new ArrayList<>();
		List<String> b = new ArrayList<>();
		for (int i = 0; i < C.length; i++) {
			if (C[i] == ',' || C[i] == ';') {
				String s = sb.toString();
				sb.setLength(0);
				if (isInteger(s)) {
					a.add(s);
				} else {
					b.add(s);
				}
			} else {
				sb.append(C[i]);
			}
		}
		String s = sb.toString();
		sb.setLength(0);
		if (isInteger(s)) {
			a.add(s);
		} else {
			b.add(s);
		}		
		System.out.println(compact(a));
		System.out.println(compact(b));
	}

	static String join(List<String> A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		int l = A.size();
		for (String o : A) {
			l--;
			sb.append(o);
			if (l > 0) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

}

