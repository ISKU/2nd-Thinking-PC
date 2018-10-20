import java.util.*;

public class Solution {

	private static Map<String, String> opcodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		opcodes = new HashMap<String, String>();
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

		int N = sc.nextInt();
		while (N-- > 0) {
			String op = sc.next();
			int rD = sc.nextInt();
			int rA = sc.nextInt();
			int rB = sc.nextInt();

			String code = convert(op, rD, rA, rB);
			System.out.println(code);
		}
	}

	private static String convert(String op, int rD, int rA, int rB) {
		StringBuilder sb = new StringBuilder();

		sb.append(opcodes.get(op)); // 0-4
		sb.append('0'); // 5
		sb.append(String.format("%03d", toBinary(rD))); // 6-8
		sb.append(String.format("%03d", toBinary(rA))); // 9-11

		if (op.charAt(op.length() - 1) == 'C') {
			sb.append(String.format("%04d", toBinary(rB))); // 12-15
		} else {
			sb.append(String.format("%03d", toBinary(rB))); // 12-14
			sb.append('0'); // 15
		}

		return sb.toString();
	}

	private static int toBinary(int value) {
		return Integer.parseInt(Integer.toBinaryString(value));
	}
}