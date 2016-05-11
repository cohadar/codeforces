import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Charlie {

	final int n;
	final TreeSet<Integer> T = new TreeSet<>();
	final TreeMap<Integer, Integer> M = new TreeMap<>();
	final int[] D;
	
	public Charlie(int n) {
		this.n = n;
		T.add(0);
		T.add(n);
		this.D = new int[n + 1];
		add(n);
	}	

	void cut(int d) {
		int l = T.floor(d);
		int r = T.higher(l);
		T.add(d);
		remove(r - l);
		add(d - l);
		add(r - d);
	}

	void add(int key) {
		Integer count = M.get(key);
		if (count == null) {
			M.put(key, 1);	
		} else {
			M.put(key, count + 1);
		}
	}
	
	void remove(int key) {
		Integer count = M.get(key);
		count--;
		if (count == 0) {
			M.remove(key);
		} else {
			M.put(key, count);
		}
	}
	
	long max() {
		return M.lastKey();
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int nx = scanner.nextInt();
		int ny = scanner.nextInt();
		int nc = scanner.nextInt();
		Charlie cx = new Charlie(nx);
		Charlie cy = new Charlie(ny);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nc; i++) {
			char c = scanner.next().charAt(0);
			int d = scanner.nextInt();
			if (c == 'H') {
				cy.cut(d);
			} else {
				cx.cut(d);
			}
			sb.append(cx.max() * cy.max());
			sb.append('\n');
		}
		System.out.print(sb);
		scanner.close();
	}

}

class FastScanner {
	private final BufferedReader in;
	private final StringBuilder sb;
	private StringTokenizer strtok;
	public FastScanner(InputStream is) {
		this.in = new BufferedReader(new InputStreamReader(is));
		this.sb = new StringBuilder();
		this.strtok = null;
	}
	public String next() {
		try {
			if (strtok == null || strtok.hasMoreTokens() == false) {
				strtok = new StringTokenizer(in.readLine());
			}
			return strtok.nextToken();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public void close() {
		try {
			in.close();
		} catch (Exception e) {
			// ignore
		}
	}
}
