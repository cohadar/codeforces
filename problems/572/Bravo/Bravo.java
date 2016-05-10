import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static boolean add(Map<Order, Integer> M, Order key) {
		Integer count = M.get(key);
		if (count == null) {
			M.put(key, 1);	
			return true;
		} else {
			M.put(key, count + 1);
			return false;
		}
	}

	public static boolean add(Map<Order, Integer> M, Order key, int delta) {
		assert delta > 0;
		Integer count = M.get(key);
		if (count == null) {
			M.put(key, delta);	
			return true;
		} else {
			M.put(key, count + delta);
			return false;
		}
	}	
	
	public static boolean remove(Map<Order, Integer> M, Order key) {
		Integer count = M.get(key);
		if (count == null) {
			return false;
		}
		count--;
		if (count == 0) {
			M.remove(key);
		} else {
			M.put(key, count);
		}
		return true;
	}
	
	public static int count(Map<Order, Integer> M, Order key) {
		Integer count = M.get(key);
		return (count == null) ? 0 : count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int nn = scanner.nextInt();
		final int ss = scanner.nextInt();
		TreeMap<Order, Integer> B = new TreeMap<>((a, b) -> Integer.compare(b.p, a.p));
		TreeMap<Order, Integer> S = new TreeMap<>((a, b) -> Integer.compare(b.p, a.p));
		for (int i = 0; i < nn; i++) {
			char d = scanner.next().charAt(0);
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			add((d == 'B') ? B : S, new Order(d, p), q);			
		}
		ArrayDeque<Order> Q = new ArrayDeque<>();
		for (int i = 0; i < ss; i++) {
			Map.Entry<Order, Integer> s = S.pollLastEntry();
			if (s == null) {
				break;
			}
			Q.addFirst(new Order(s.getKey().d, s.getKey().p, s.getValue()));
		}
		for (int i = 0; i < ss; i++) {
			Map.Entry<Order, Integer> b = B.pollFirstEntry();
			if (b == null) {
				break;
			}
			Q.addLast(new Order(b.getKey().d, b.getKey().p, b.getValue()));			
		}
		StringBuilder sb = new StringBuilder();
		for (Order o : Q) {
			sb.append(o);
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void debug(Object...os) {
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}
	
}

class Order {
	final char d;
	final int p;
	final int q;
	Order(char d, int p) {
		this.d = d;
		this.p = p;
		this.q = 0;
	}
	Order(char d, int p, int q) {
		this.d = d;
		this.p = p;
		this.q = q;
	}	
	public String toString() {
		return String.format("%c %d %d", d, p, q);
	}	
}
