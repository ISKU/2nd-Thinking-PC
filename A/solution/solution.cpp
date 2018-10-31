#include <stdio.h>
#include <algorithm>
using namespace std;

int calculate(int A, char oper, int B) {
    switch (oper) {
        case '*':
            return A * B;
        case '/':
            return A / B;
        case '+':
            return A + B;
        case '-':
            return A - B;
        default:
            return 0;
    }
}

int main() {
    int K1, K2, K3;
    char O1, O2;
    scanf("%d %c %d %c %d", &K1, &O1, &K2, &O2, &K3);

    int first = calculate(calculate(K1, O1, K2), O2, K3);
    int second = calculate(K1, O1, calculate(K2, O2, K3));
    printf("%d\n", min(first, second));
    printf("%d\n", max(first, second));
}
