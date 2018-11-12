#include <stdio.h>
#include <algorithm>
#include <math.h>
using namespace std;

int op(int a, char c, int b) {
    if (c == '+')
        return a + b;
    else if (c == '-')
        return a - b;
    else if (c == '*')
        return a * b;
    else if (c == '/')
        return (int) floor(1.0 * a / b);
    else
        return -1;
}

int main() {
    int a, b, c;
    char o1, o2;
    scanf("%d %c %d %c %d", &a, &o1, &b, &o2, &c);

    int t1 = op(op(a, o1, b), o2, c);
    int t2 = op(a, o1, op(b, o2, c));
    if (t1 > t2)
        swap(t1, t2);
    printf("%d\n%d\n", t1, t2);

    return 0;
}
