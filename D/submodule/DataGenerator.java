import java.io.*;
import java.util.*;

public class DataGenerator {

	private static final int MIN_N = 1;
	private static final int MAX_N = 500;
	private static final int MIN_R = 1;
	private static final int MAX_R = 7;
	private static final int MIN_C = 0;
	private static final int MAX_C = 15;

	private static final String[] OPCODE = new String[] { "ADD", "ADDC", "SUB", "SUBC", "MOV", "MOVC", "AND", "ANDC",
			"OR", "ORC", "NOT", "MULT", "MULTC", "LSFTL", "LSFTLC", "LSFTR", "LSFTRC", "ASFTR", "ASFTRC", "RL", "RLC",
			"RR", "RRC" };

	private static final int START = 1;
	private static final int END = 45;

	public static void main(String[] args) throws Exception {
		for (int i = START; i <= END; i++)
			generate(i);
	}

	private static void generate(int nth) throws Exception {
		int N = random(MIN_N, MAX_N);

		Code[] codes = new Code[N];
		for (int i = 0; i < N; i++) {
			String opcode = OPCODE[random(0, OPCODE.length - 1)];

			if (opcode.charAt(opcode.length() - 1) == 'C') {
				int rD = random(MIN_R, MAX_R);
				int rA = containsOpcode(opcode) ? 0 : random(MIN_R, MAX_R);
				int C = random(MIN_C, MAX_C);
				codes[i] = new Code(opcode, rD, rA, C, true);
			} else {
				int rD = random(MIN_R, MAX_R);
				int rA = containsOpcode(opcode) ? 0 : random(MIN_R, MAX_R);
				int rB = random(MIN_R, MAX_R);
				codes[i] = new Code(opcode, rD, rA, rB, false);
			}
		}

		generateInput(nth, N, codes);
		generateOutput(nth, N, codes);
	}

	private static void generateInput(int nth, int N, Code[] codes) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".in"));

		bw.write(String.format("%d\n", N));

		for (int i = 0; i < N; i++) {
			String opcode = codes[i].opcode;

			if (opcode.charAt(opcode.length() - 1) == 'C') {
				int rD = codes[i].rD;
				int rA = codes[i].rA;
				int C = codes[i].C;
				bw.write(String.format("%s %d %d %d\n", opcode, rD, rA, C));
			} else {
				int rD = codes[i].rD;
				int rA = codes[i].rA;
				int rB = codes[i].rB;
				bw.write(String.format("%s %d %d %d\n", opcode, rD, rA, rB));
			}
		}

		bw.close();
	}

	private static void generateOutput(int nth, int N, Code[] codes) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nth + ".out"));

		for (int i = 0; i < N; i++)
			bw.write(String.format("%s\n", solve(codes[i])));

		bw.close();
	}

	private static String solve(Code code) {
		Map<String, String> opcodes = new HashMap<>();
		opcodes.put("ADD", "00000");
		opcodes.put("ADDC", "00001");
		opcodes.put("SUB", "00010");
		opcodes.put("SUBC", "00011");
		opcodes.put("MOV", "00100");
		opcodes.put("MOVC", "00101");
		opcodes.put("AND", "00110");
		opcodes.put("ANDC", "00111");
		opcodes.put("OR", "01000");
		opcodes.put("ORC", "01001");
		opcodes.put("NOT", "01010");
		opcodes.put("MULT", "01100");
		opcodes.put("MULTC", "01101");
		opcodes.put("LSFTL", "01110");
		opcodes.put("LSFTLC", "01111");
		opcodes.put("LSFTR", "10000");
		opcodes.put("LSFTRC", "10001");
		opcodes.put("ASFTR", "10010");
		opcodes.put("ASFTRC", "10011");
		opcodes.put("RL", "10100");
		opcodes.put("RLC", "10101");
		opcodes.put("RR", "10110");
		opcodes.put("RRC", "10111");

		StringBuilder sb = new StringBuilder();
		sb.append(opcodes.get(code.opcode)); // 0-4
		sb.append("0"); // 5
		sb.append(String.format("%03d", toBinary(code.rD))); // 6-8
		sb.append(String.format("%03d", toBinary(code.rA))); // 9-11

		if (code.opcode.charAt(code.opcode.length() - 1) == 'C') {
			sb.append(String.format("%04d", toBinary(code.C))); // 12-15
		} else {
			sb.append(String.format("%03d", toBinary(code.rB))); // 12-14
			sb.append("0"); // 15
		}

		return sb.toString();
	}

	private static int random(int L, int R) {
		return (int) (Math.random() * (R - L + 1)) + L;
	}

	private static int toBinary(int value) {
		return Integer.parseInt(Integer.toBinaryString(value));
	}

	private static boolean containsOpcode(String opcode) {
		switch (opcode) {
		case "MOV":
		case "MOVC":
		case "NOT":
			return true;
		default:
			return false;
		}
	}

	private static class Code {
		public String opcode;
		public int rD, rA, rB, C;

		public Code(String opcode, int rD, int rA, int rB, boolean c) {
			this.opcode = opcode;
			this.rD = rD;
			this.rA = rA;
			if (c)
				this.C = rB;
			else
				this.rB = rB;
		}
	}
}