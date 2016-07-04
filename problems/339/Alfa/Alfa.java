import java.util.*;
import java.io.*;

/**
  * @author Mighty Cohadar 
  */
public class Alfa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] s = scanner.nextLine().split("\\+");
		Arrays.sort(s); 
		System.out.println(String.join("+", s));
	}

}
