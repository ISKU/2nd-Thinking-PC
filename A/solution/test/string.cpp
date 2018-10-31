#include <iostream>
#include <algorithm>
using namespace std;

int calculate(int A, string oper, int B) {
    if (oper == "*")
        return A * B;
    else if (oper == "/")
        return A / B;
    else if (oper == "+")
        return A + B;
    else if (oper == "-")
        return A - B;
}

int main() {
    int K1, K2, K3;
    string O1, O2;
    cin >> K1 >> O1 >> K2 >> O2 >> K3;

    int first = calculate(calculate(K1, O1, K2), O2, K3);
    int second = calculate(K1, O1, calculate(K2, O2, K3));
    printf("%d\n", min(first, second));
    printf("%d\n", max(first, second));
}
