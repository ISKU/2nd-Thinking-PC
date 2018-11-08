import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int Q = sc.nextInt();

		int[][] psum = new int[R + 1][C + 1];
		for (int r = 1; r <= R; r++)
			for (int c = 1; c <= C; c++)
				psum[r][c] = sc.nextInt() + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];

		while (Q-- > 0) {
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			int sum = psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1];
			int n = (r2 - r1 + 1) * (c2 - c1 + 1);
			System.out.println(sum / n);
		}
	}
}
