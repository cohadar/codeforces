import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Alfa {

	public static final int HIDDEN = 12345;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static boolean lte(int m) throws Exception {
		System.out.println(m);
		System.out.flush();
		String s = br.readLine().trim();
		return s.indexOf('=') >= 0;
	}

	public static boolean lte2(int m) {
		if (HIDDEN >= m) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {	
		int l = 1, r = 1000000;
		while (l != r) {
		    int mid = (l + r + 1) >>> 1;
		    if (lte(mid)) {
		    	l = mid;
		    } else {
		        r = mid - 1;
		    }
		}

		System.out.printf("! %d\n", l);
		System.out.flush();
	}
}
