import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum = 0;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				sum += sc.nextInt();

		System.out.print(sum);
	}
}