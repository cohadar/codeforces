import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class A {

	public static int sum(int index, int field) {
		int sum = 0;
		for (Calendar calendar = new GregorianCalendar(2016, Calendar.JANUARY, 1); calendar.get(Calendar.YEAR) == 2016; calendar.add(Calendar.DAY_OF_YEAR, 1)) {
			sum += (calendar.get(field) == index) ? 1 : 0;
		}
		return sum;
	}

	// convert DAY_OF_WEEK from monday = 1 format to sunday = 1 format
	public static int sunday_first(int index) {
		return index % 7 + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] in = scanner.nextLine().split(" ");
		int index = Integer.valueOf(in[0]);
		int candies = ("week".equals(in[2])) ? sum(sunday_first(index), Calendar.DAY_OF_WEEK) : sum(index, Calendar.DAY_OF_MONTH);
		System.out.println(candies);
	}

}

