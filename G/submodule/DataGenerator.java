import java.io.*;

public class DataGenerator {

	private static final int MIN_T = 1;
	private static final int MAX_T = 10;
	private static final int MIN_N = 1;
	private static final int MAX_N = 16;
	private static final int MIN_C = 10_000;
	private static final int MAX_C = 100_000;
	private static final int MIN_W = 1;
	private static final int MAX_W = 50;

	private static final int START = 1;
	private static final int END = 100;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int sizeT = random(MIN_T, MAX_T);
		String T = "";
		for (int i = 0; i < sizeT; i++)
			T += (char) random('A', 'Z');

		int N = random(MIN_N, MAX_N);
		Book[] books = new Book[N];
		for (int i = 0; i < N; i++) {
			int C = random(MIN_C, MAX_C);
			int sizeW = random(MIN_W, MAX_W);
			String W = "";
			for (int j = 0; j < sizeW; j++)
				W += (char) random('A', 'Z');

			books[i] = new Book(C, W);
		}

		generateInput(nth, T, N, books);
		generateOutput(nth, T, N, books);
	}

	private static void generateInput(int nth, String T, int N, Book[] books) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));

		bw.write(String.format("%s\n", T));
		bw.write(String.format("%d\n", N));
		for (int i = 0; i < books.length; i++)
			bw.write(String.format("%d %s\n", books[i].C, books[i].W));

		bw.close();
	}

	private static void generateOutput(int nth, String T, int N, Book[] books) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));

		bw.write(String.format("%d\n", solve(T, N, books)));

		bw.close();
	}

	private static int solve(String T, int N, Book[] books) {
		int[] letter = new int[26];
		for (int i = 0; i < T.length(); i++)
			letter[T.charAt(i) - 'A']++;

		int answer = Integer.MAX_VALUE;
		int size = 1 << N;
		for (int n = 1; n < size; n++) {
			int[] count = new int[26];
			int cost = 0;

			for (int d = 1, idx = 0; d <= n; d <<= 1, idx++) {
				if ((n & d) != d)
					continue;

				cost += books[idx].C;
				for (int i = 0; i < 26; i++)
					count[i] += books[idx].letter[i];
			}

			boolean check = true;
			for (int i = 0; i < 26; i++) {
				if (count[i] < letter[i]) {
					check = false;
					break;
				}
			}

			if (check)
				answer = Math.min(answer, cost);
		}

		return (answer == Integer.MAX_VALUE) ? -1 : answer;
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}

	private static class Book {
		public int C;
		public String W;
		public int[] letter;

		public Book(int C, String W) {
			this.C = C;
			this.W = W;

			this.letter = new int[26];
			for (int i = 0; i < W.length(); i++)
				this.letter[W.charAt(i) - 'A']++;
		}
	}
}