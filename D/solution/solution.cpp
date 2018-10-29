#include <iostream>
#include <string>
#include <map>
using namespace std;

map<string, string> opcodes;

string to_binary(int value, int size) {
    int binary[] = { 0, 0, 0, 0 };

    for (int i = 3; i >= 0; i--) {
        binary[i] = value % 2;
        value /= 2;
    }

    string ret;
    for (int i = 4 - size; i < 4; i++)
        ret += to_string(binary[i]);

    return ret;
}

string convert(string op, int rD, int rA, int rB) {
    string code;

    code += opcodes[op]; // 0-4
    code += "0"; // 5
    code += to_binary(rD, 3); // 6-8
    code += to_binary(rA, 3); // 9-11

    if (op[op.length() - 1] == 'C') {
        code += to_binary(rB, 4); // 12-15
    } else {
        code += to_binary(rB, 3); // 12-14
        code += "0"; // 15
    }

    return code;
}

int main() {
    opcodes["ADD"] = "00000";
    opcodes["ADDC"] = "00001";
    opcodes["SUB"] = "00010";
    opcodes["SUBC"] = "00011";
    opcodes["MOV"] = "00100";
    opcodes["MOVC"] = "00101";
    opcodes["AND"] = "00110";
    opcodes["ANDC"] = "00111";
    opcodes["OR"] = "01000";
    opcodes["ORC"] = "01001";
    opcodes["NOT"] = "01010";
    opcodes["MULT"] = "01100";
    opcodes["MULTC"] = "01101";
    opcodes["LSFTL"] = "01110";
    opcodes["LSFTLC"] = "01111";
    opcodes["LSFTR"] = "10000";
    opcodes["LSFTRC"] = "10001";
    opcodes["ASFTR"] = "10010";
    opcodes["ASFTRC"] = "10011";
    opcodes["RL"] = "10100";
    opcodes["RLC"] = "10101";
    opcodes["RR"] = "10110";
    opcodes["RRC"] = "10111";

    int N;
    cin >> N;
    while (N-- > 0) {
        string op;
        int rD, rA, rB;
        cin >> op >> rD >> rA >> rB;

        string code = convert(op, rD, rA, rB);
        cout << code << "\n";
    }

    return 0;
}
