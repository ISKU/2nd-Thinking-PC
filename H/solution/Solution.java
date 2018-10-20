import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] queue = new int[N + 1];
		for (int i = 1; i <= N; i++)
			queue[i] = sc.nextInt();

		int[] psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + queue[i];

		while (M-- > 0) {
			int T = sc.nextInt();
			System.out.println(lowerBound(psum, T));
		}
	}

	private static int lowerBound(int[] array, int value) {
		int l = 0;
		int r = array.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (array[mid] < value)
				l = mid + 1;
			else
				r = mid;
		}

		return (array[l] <= value) ? l : l - 1;
	}
}