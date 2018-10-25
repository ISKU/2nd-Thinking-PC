import java.io.*;

public class DataGenerator {

	private static final int MIN_N = 1;
	private static final int MAX_N = 200_000;
	private static final int MIN_M = 1;
	private static final int MAX_M = 200_000;
	private static final int MIN_t = 1;
	private static final int MAX_t = 10_000;
	private static final int MIN_T = 1;
	private static final int MAX_T = 2_000_000_000;

	private static final int START = 1;
	private static final int END = 20;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int N = random(MIN_N, MAX_N);
		int M = random(MIN_M, MAX_M);

		int[] queue = new int[N];
		for (int i = 0; i < N; i++)
			queue[i] = random(MIN_t, MAX_t);

		int[] query = new int[M];
		for (int i = 0; i < M; i++)
			query[i] = random(MIN_T, MAX_T);

		generateInput(nth, N, M, queue, query);
		generateOutput(nth, N, M, queue, query);
	}

	private static void generateInput(int nth, int N, int M, int[] queue, int[] query) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));

		bw.write(String.format("%d %d\n", N, M));

		bw.write(String.valueOf(queue[0]));
		for (int i = 1; i < N; i++)
			bw.write(" " + queue[i]);
		bw.write("\n");

		for (int i = 0; i < M; i++)
			bw.write(query[i] + "\n");

		bw.close();
	}

	private static void generateOutput(int nth, int N, int M, int[] queue, int[] query) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));

		int[] answer = solve(N, M, queue, query);
		for (int i = 0; i < M; i++)
			bw.write(answer[i] + "\n");

		bw.close();
	}

	private static int[] solve(int N, int M, int[] queue, int[] query) {
		int[] psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + queue[i - 1];

		int[] answer = new int[M];
		for (int i = 0; i < M; i++) {
			int l = 0;
			int r = psum.length - 1;

			while (l < r) {
				int mid = (l + r) / 2;

				if (psum[mid] < query[i])
					l = mid + 1;
				else
					r = mid;
			}

			answer[i] = (psum[l] <= query[i]) ? l : l - 1;
		}

		return answer;
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}
}
