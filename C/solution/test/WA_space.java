import java.util.*;

public class Solution {
	public static void main(String[] args) {
		boolean[][] array = new boolean[1025][1025];
		array[1][1] = true;
		for (int size = 1; size <= 512; size *= 2) {
			for (int y = 1; y <= size; y++) {
				for (int x = 1; x <= size; x++) {
					array[y][x + size] = array[y][x];
					array[y + size][x] = array[y][x];
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 0) {
			System.out.print("*");
			System.exit(0);
		}

		for (int y = 1; y <= (1 << N); y++) {
			for (int x = 1; x <= (1 << N); x++)
				System.out.print(array[y][x] ? "*" : " ");
			System.out.println();
		}
	}
}