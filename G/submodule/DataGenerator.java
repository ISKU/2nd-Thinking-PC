import java.util.*;
import java.io.*;

public class DataGenerator {

	private static final int MIN_PIECE_Y = 0;
	private static final int MAX_PIECE_Y = 9;
	private static final int MIN_PIECE_X = 0;
	private static final int MAX_PIECE_X = 8;
	private static final int[] RANGE_KING_Y = new int[] { 0, 1, 2, 7, 8, 9 };
	private static final int[] RANGE_KING_X = new int[] { 3, 4, 5 };

	private static final int START = 1;
	private static final int END = 50;

	private static final int[] dy = new int[] { -3, -3, -2, 2, 3, 3, 2, -2 };
	private static final int[] dx = new int[] { -2, 2, 3, 3, 2, -2, -3, -3 };
	private static final int[] cy = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	private static final int[] cx = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };
	private static final int[] ay = new int[] { -1, -1, 0, 0, 1, 1, 0, 0 };
	private static final int[] ax = new int[] { 0, 0, 1, 1, 0, 0, -1, -1 };
	private static final int Y = 10;
	private static final int X = 9;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int sangY = random(MIN_PIECE_Y, MAX_PIECE_Y);
		int sangX = random(MIN_PIECE_X, MAX_PIECE_X);
		int kingY = RANGE_KING_Y[random(0, RANGE_KING_Y.length - 1)];
		int kingX = RANGE_KING_X[random(0, RANGE_KING_X.length - 1)];
		if (sangY == kingY && sangX == kingX) {
			generate(nth);
			return;
		}

		Piece sang = new Piece(sangY, sangX, 0);
		Piece king = new Piece(kingY, kingX, 0);
		generateInput(nth, sang, king);
		generateOutput(nth, sang, king);
	}

	private static void generateInput(int nth, Piece sang, Piece king) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));
		bw.write(String.format("%d %d\n", sang.y, sang.x));
		bw.write(String.format("%d %d\n", king.y, king.x));
		bw.close();
	}

	private static void generateOutput(int nth, Piece sang, Piece king) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));
		bw.write(String.format("%d\n", solve(sang, king)));
		bw.close();
	}

	private static int solve(Piece sang, Piece king) {
		Queue<Piece> q = new LinkedList<Piece>();
		boolean[][] visited = new boolean[Y][X];
		q.add(sang);
		visited[sang.y][sang.x] = true;

		while (!q.isEmpty()) {
			Piece u = q.poll();
			if (u.y == king.y && u.x == king.x)
				return u.count;

			for (int i = 0; i < 8; i++) {
				int y = u.y + ay[i];
				int x = u.x + ax[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
					continue;

				y = u.y + cy[i];
				x = u.x + cx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
					continue;

				y = u.y + dy[i];
				x = u.x + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x])
					continue;

				q.add(new Piece(y, x, u.count + 1));
				visited[y][x] = true;
			}
		}

		return -1;
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}

	private static class Piece {
		public int y, x, count;

		public Piece(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}