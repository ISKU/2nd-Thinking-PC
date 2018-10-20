import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] queue = new int[N + 1];
		for (int i = 1; i <= N; i++)
			queue[i] = Integer.parseInt(st.nextToken());

		int[] psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + queue[i];

		while (M-- > 0) {
			int T = Integer.parseInt(br.readLine());

			int i = 1;
			for (; i <= N; i++)
				if (psum[i] > T)
					break;

			bw.write((i - 1) + "\n");
		}

		bw.close();
	}
}
