import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Bravo {

	static void insertionSort(int[] A, int li, int re) {
		for (int r = li + 1; r < re; r++) {
			int val = A[r];
			int l = r;
			while (li < l && A[l-1] > val) {
				A[l] = A[l-1];
				l--;
			}
			A[l] = val;
		}
	}
	
	static void merge(int[] A, int[] B, int li, int mi, int re) {
		int l = li;
		int r = mi;
		int j = li;
		while (l < mi && r < re) {
			if (A[l] <= A[r]) {
				B[j++] = A[l++];
			} else {
				B[j++] = A[r++];
			}
		}
		while (l < mi) {
			B[j++] = A[l++];
		}
		for (int i = li; i < j; i++) {
			A[i] = B[i];
		}
	}
	
	static void mergeSort(int[] A, int[] B, int li, int re) {
		if (li >= re) {
			return;
		}
		if (re - li <= 10) {
			insertionSort(A, li, re);
		} else {
			int mi = (li + re) >>> 1;
			mergeSort(A, B, li, mi);
			mergeSort(A, B, mi, re);
			merge(A, B, li, mi, re);
		}
	}
	
	static void mergeSort(int[] A, int li, int re) {
		mergeSort(A, new int[A.length], li, re);
	}

	public static void main(String[] args) throws Exception {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		mergeSort(A, 0, A.length);
		int j = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= j) {
				j++;
			}
		}
		System.out.println(j);
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
	public long nextLong() {
		return Long.parseLong(next());
	}
	public String nextLine() {
		try {
			if (strtok == null) {
				return in.readLine();
			} else {
				String ret = (strtok.hasMoreTokens()) ? strtok.nextToken("\n") : "";
				strtok = null;
				return ret;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

