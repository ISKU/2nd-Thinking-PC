import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
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

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = new Scanner(System.in).nextInt();
		if (N == 0) {
			System.out.print("*");
			System.exit(0);
		}

		for (int y = 1; y <= (1 << N); y++) {
			int end = 1 << N;
			for (int x = end; x >= 1; x--) {
				if (array[y][x]) {
					end = x;
					break;
				}
			}

			for (int x = 1; x <= end; x++)
				bw.write(array[y][x] ? "*" : " ");
			bw.write("\n");
		}
		bw.close();
	}
}