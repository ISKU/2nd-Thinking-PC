import java.util.*;

public class Solution {

	private static Book[] books;
	private static int[] letter, count;
	private static int N, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		letter = new int[26];
		String T = sc.next();
		for (int i = 0; i < T.length(); i++)
			letter[T.charAt(i) - 'A']++;

		N = sc.nextInt();
		books = new Book[N];
		for (int i = 0; i < N; i++)
			books[i] = new Book(sc.nextInt(), sc.next());

		answer = Integer.MAX_VALUE;
		count = new int[26];
		dfs(0, 0);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void dfs(int idx, int cost) {
		if (idx >= N)
			return;

		dfs(idx + 1, cost);

		cost += books[idx].C;
		for (int i = 0; i < 26; i++)
			count[i] += books[idx].letter[i];

		boolean check = true;
		for (int i = 0; i < 26; i++) {
			if (count[i] < letter[i]) {
				check = false;
				break;
			}
		}
		if (check)
			answer = Math.min(answer, cost);

		dfs(idx + 1, cost);

		cost -= books[idx].C;
		for (int i = 0; i < 26; i++)
			count[i] -= books[idx].letter[i];
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