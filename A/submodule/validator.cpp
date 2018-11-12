#include <stdio.h>
#include <assert.h>
#include <algorithm>
using namespace std;

int op(int a, char c, int b) {
    if (c == '+')
        return a + b;
    else if (c == '-')
        return a - b;
    else if (c == '*')
        return a * b;
    else if (c == '/') {
        assert(b != 0);
        bool sgn = false;
        if (a < 0) sgn = !sgn;
        if (b < 0) sgn = !sgn;
        return abs(a / b) * (sgn ? -1 : 1);
    }
    else {
        assert(false);
        return -1;
    }
}

int main() {
    int a, b, c;
    char o1, o2;
    scanf("%d %c %d %c %d", &a, &o1, &b, &o2, &c);
    assert(1 <= a && a <= 1000 && 1 <= b && b <= 1000 && 1 <= c && c <= 1000);

    int t1 = op(op(a, o1, b), o2, c);
    int t2 = op(a, o1, op(b, o2, c));
    if (t1 > t2)
        swap(t1, t2);
    printf("%d\n%d\n", t1, t2);

    return 0;
}
