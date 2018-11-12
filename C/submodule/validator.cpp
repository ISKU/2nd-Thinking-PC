#include <stdio.h>
#include <assert.h>
#include <algorithm>
#include <iostream>
using namespace std;

typedef long long lli;

char res[1024][1025];

void make(int cur, int tar) {
    if (cur == tar)
        return;

    ++cur;
    int step = (1 << cur);
    for (int i = step / 2; i < step; i++)
        for (int j = 0; j <= i; j++)
            res[i][j] = res[i - step / 2][j % (step / 2)];

    make(cur, tar);
}

int main() {
    int n;
    scanf("%d", &n);
    assert(0 <= n && n <= 10);

    for (int i = 0; i < (1 << n); i++)
        for (int j = 0; j < (1 << n); j++)
            res[i][j] = ' ';

    res[0][0] = '*';
    make(0, n);
    for (int i = (1 << n) - 1; i >= 0; i--) {
        res[i][i + 1] = 0;
        puts(res[i]);
    }
    return 0;
}
