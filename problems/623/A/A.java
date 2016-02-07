import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class A {

	final int[][] G;
	final char[] C;
	
	public A(int[][] G) {
		this.G = G;
		this.C = new char[G.length];
		Arrays.fill(C, 'b');
	}

	public boolean hasDisconnects(int k) {
		for (int j = 0; j < G.length; j++) {
			if (j == k) { continue; };
			if (G[j][k] == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean bfs(int k) {
		if (G[k] == 'b') {
			if (hasDisconnects(k)) {
				G[k] = 'a';
				for (int j = 0; j < G.length; j++) {
					if (j == k) {
						continue;
					}
					if (G[j][k] == 0) {
						
					}
				}
			}
		}
		return true;
	}

	public boolean solve() {
		for (int i = 0; i < G.length; i++) {
			if (bfs(i) == false) {
				return false;
			}
		}
		return true;
	}

	public static A load(Scanner scanner) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		assert 1 <= n && n <= 500 : "out of range, n: " + n;
		assert 0 <= m && m <= n * (n - 1) / 2 : "out of range, m: " + m;
		int[][] G = scanGraph(scanner, n, m);
		return new A(G);
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		A o = A.load(scanner);
		if (o.solve()) {
			System.out.println("Yes");
			System.out.println(join(o.C, ""));
		} else {
			System.out.println("No");
		}
	}

	static int[][] scanGraph(Scanner scanner, int n, int m) {
		int[][] G = new int[n][n];
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			G[a][b] = 1;
			G[b][a] = 1;
		}	
		return G;
	}

	static String join(char[] A, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (char o : A) {
			sb.append(o);
			sb.append(delimiter);
		}
		return sb.toString();
	}

}
