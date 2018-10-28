import java.io.*;

public class DataGenerator {

	private static final int MIN_N = 2;
	private static final int MAX_N = 1024;
	private static final int[] RANGE_N = new int[] { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
	private static final int MIN_K = 1;
	private static final int MAX_K = 100_000;

	private static final int START = 1;
	private static final int END = 20;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int N = RANGE_N[random(0, RANGE_N.length - 1)];
		if ((-N & N) != N) {
			generate(nth);
			return;
		}

		long[][] array = new long[N][N];
		for (int y = 0; y < array.length; y++)
			for (int x = 0; x < array[y].length; x++)
				array[y][x] = random(MIN_K, MAX_K);

		generateInput(nth, array, N);
		generateOutput(nth, array, N);
	}

	private static void generateInput(int nth, long[][] array, int N) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));

		bw.write(String.format("%d\n", N));

		for (int y = 0; y < N; y++) {
			bw.write(String.format("%d", array[y][0]));
			for (int x = 1; x < N; x++)
				bw.write(String.format(" %d", array[y][x]));
			bw.write("\n");
		}

		bw.close();
	}

	private static void generateOutput(int nth, long[][] array, int N) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));
		bw.write(String.format("%d\n", solve(array, N)));
		bw.close();
	}

	private static long solve(long[][] array, int N) {
		long sum = 0;

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				sum += array[y][x];

		return sum;
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}
}