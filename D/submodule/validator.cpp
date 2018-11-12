#include <iostream>
#include <string>
#include <assert.h>
using namespace std;

int n;
string s;

string o[24] = { "ADD","ADDC","SUB","SUBC","MOV","MOVC","AND","ANDC","OR","ORC","NOT","NOT","MULT","MULTC","LSFTL","LSFTLC","LSFTR","LSFTRC","ASFTR","ASFTRC","RL","RLC","RR","RRC" };
string c[12] = { "0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011" };
string p3[8] = { "000","001","010","011","100","101","110","111" };
string p4[16] = { "0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111" };

int main() {
    cin >> n;
    while (n--) {
        string op;
        int d, a, b;
        cin >> op >> d >> a >> b;

        int idx = -1;
        for (int i = 0; i < 24; i++) {
            if (op == o[i]) {
                idx = i;
                break;
            }
        }

        assert(idx >= 0);
        assert(0 <= d && d <= 7);

        if (idx / 2 == 2 || idx / 2 == 5)
            assert(a == 0);
        else
            assert(1 <= a && a <= 7);

        if (idx % 2 == 0)
            assert(1 <= b && b <= 7);
        else
            assert(0 <= b && b <= 15);

        cout << c[idx / 2] << idx % 2 << "0" << p3[d];
        if (idx / 2 == 2 || idx / 2 == 5)
            cout << "000";
        else
            cout << p3[a];

        if (idx % 2 == 0)
            cout << p3[b] << "0" << endl;
        else
            cout << p4[b] << endl;
    }
    return 0;
}
