import java.io.*;

public class DataGenerator {

	private static final int MIN_K = 1;
	private static final int MAX_K = 1_000;
	private static final String[] OPERATOR = new String[] { "*", "/", "+", "-" };

	private static final int START = 1;
	private static final int END = 100;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int K1 = random(MIN_K, MAX_K);
		int K2 = random(MIN_K, MAX_K);
		int K3 = random(MIN_K, MAX_K);
		String O1 = OPERATOR[random(0, OPERATOR.length - 1)];
		String O2 = OPERATOR[random(0, OPERATOR.length - 1)];

		if ("/".equals(O1) && calculate(K2, O2, K3) == 0) {
			generate(nth);
			return;
		}
		generateInput(nth, K1, O1, K2, O2, K3);
		generateOutput(nth, K1, O1, K2, O2, K3);
	}

	private static void generateInput(int nth, int K1, String O1, int K2, String O2, int K3) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));
		bw.write(String.format("%d %s %d %s %d\n", K1, O1, K2, O2, K3));
		bw.close();
	}

	private static void generateOutput(int nth, int K1, String O1, int K2, String O2, int K3) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));

		int[] answer = solve(K1, O1, K2, O2, K3);
		bw.write(String.format("%d\n", answer[0]));
		bw.write(String.format("%d\n", answer[1]));

		bw.close();
	}

	private static int[] solve(int K1, String O1, int K2, String O2, int K3) {
		int first = calculate(calculate(K1, O1, K2), O2, K3);
		int second = calculate(K1, O1, calculate(K2, O2, K3));
		return new int[] { Math.min(first, second), Math.max(first, second) };
	}

	private static int calculate(int A, String operator, int B) {
		switch (operator) {
		case "*":
			return A * B;
		case "/":
			return A / B;
		case "+":
			return A + B;
		case "-":
			return A - B;
		default:
			return 0;
		}
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}
}