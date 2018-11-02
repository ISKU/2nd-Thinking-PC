import java.io.*;

public class DataGenerator {

	private static final int MIN_R = 1;
	private static final int MAX_R = 1_000;
	private static final int MIN_C = 1;
	private static final int MAX_C = 1_000;
	private static final int MIN_Q = 1;
	private static final int MAX_Q = 10_000;
	private static final int MIN_K = 1;
	private static final int MAX_K = 1_000;

	private static final int START = 1;
	private static final int END = 25;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int R = random(MIN_R, MAX_R);
		int C = random(MIN_C, MAX_C);
		int Q = random(MIN_Q, MAX_Q);

		int[][] image = new int[R + 1][C + 1];
		for (int r = 1; r <= R; r++)
			for (int c = 1; c <= C; c++)
				image[r][c] = random(MIN_K, MAX_K);

		Query[] queries = new Query[Q];
		for (int i = 0; i < Q; i++) {
			int r1 = random(MIN_R, R);
			int c1 = random(MIN_C, C);
			int r2 = random(r1, R);
			int c2 = random(c1, C);
			queries[i] = new Query(r1, r2, c1, c2);
		}

		generateInput(nth, R, C, Q, image, queries);
		generateOutput(nth, R, C, Q, image, queries);
	}

	private static void generateInput(int nth, int R, int C, int Q, int[][] image, Query[] queries) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));

		bw.write(String.format("%d %d %d\n", R, C, Q));

		for (int r = 1; r <= R; r++) {
			bw.write(String.format("%d", image[r][1]));
			for (int c = 2; c <= C; c++)
				bw.write(String.format(" %d", image[r][c]));
			bw.write("\n");
		}

		for (int i = 0; i < Q; i++) {
			int r1 = queries[i].r1;
			int r2 = queries[i].r2;
			int c1 = queries[i].c1;
			int c2 = queries[i].c2;
			bw.write(String.format("%d %d %d %d\n", r1, r2, c1, c2));
		}

		bw.close();
	}

	private static void generateOutput(int nth, int R, int C, int Q, int[][] image, Query[] queries) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));

		int[] answer = solve(R, C, Q, image, queries);
		for (int i = 0; i < Q; i++)
			bw.write(String.format("%d\n", answer[i]));

		bw.close();
	}

	private static int[] solve(int R, int C, int Q, int[][] image, Query[] queries) {
		int[][] psum = new int[R + 1][C + 1];
		for (int r = 1; r <= R; r++)
			for (int c = 1; c <= C; c++)
				psum[r][c] = image[r][c] + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];

		int[] answer = new int[Q];
		for (int i = 0; i < Q; i++) {
			int r1 = queries[i].r1;
			int r2 = queries[i].r2;
			int c1 = queries[i].c1;
			int c2 = queries[i].c2;

			int sum = psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1];
			int n = (r2 - r1 + 1) * (c2 - c1 + 1);
			answer[i] = sum / n;
		}

		return answer;
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}

	private static class Query {
		public int r1, r2, c1, c2;

		public Query(int r1, int r2, int c1, int c2) {
			this.r1 = r1;
			this.r2 = r2;
			this.c1 = c1;
			this.c2 = c2;
		}
	}
}