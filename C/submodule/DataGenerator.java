import java.io.*;

public class DataGenerator {

	private static final int MIN_N = 0;
	private static final int MAX_N = 10;

	private static final int START = 1;
	private static final int END = 11;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int N = nth - 1;

		generateInput(nth, N);
		generateOutput(nth, N);
	}

	private static void generateInput(int nth, int N) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));
		bw.write(String.format("%d\n", N));
		bw.close();
	}

	private static void generateOutput(int nth, int N) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));
		if (N == 0) {
			bw.write("*\n");
			bw.close();
			return;
		}

		boolean[][] array = solve(N);
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

	private static boolean[][] solve(int N) {
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

		return array;
	}
}