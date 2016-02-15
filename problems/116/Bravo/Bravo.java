import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Bravo {

	public static boolean hasWolf(char[][] C, int y, int x) {
		if (C[y+1][x] == 'W') { C[y+1][x] = '.'; return true;}
		if (C[y-1][x] == 'W') { C[y-1][x] = '.'; return true;}
		if (C[y][x+1] == 'W') { C[y][x+1] = '.'; return true;}
		if (C[y][x-1] == 'W') { C[y][x-1] = '.'; return true;}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] _nynx = scanner.nextLine().split(" ");
		int ny = Integer.valueOf(_nynx[0]);
		int nx = Integer.valueOf(_nynx[1]);
		assert 1 <= nx && nx <= 10 : "out of range, nx: " + nx;
		assert 1 <= ny && ny <= 10 : "out of range, ny: " + ny;
		char[][] C = scanCharMatrix(scanner, ny, nx);
		int count = 0;
		for (int y = 1; y <= ny; y++) {
			for (int x = 1; x <= nx; x++) {
				if (C[y][x] == 'P' && hasWolf(C, y, x)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static char[][] scanCharMatrix(Scanner scanner, int ny, int nx) {
		char[][] C = new char[ny + 2][nx + 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nx + 2; i++) {
			sb.append('.');
		}
		char[] wall = sb.toString().toCharArray();
		C[0] = wall;
		for (int y = 1; y <= ny; y++) {
			C[y] = ('.' + scanner.nextLine().trim() + '.').toCharArray();
			assert C[y].length == nx + 2;
		}
		C[ny + 1] = wall;
		return C;
	}

}

