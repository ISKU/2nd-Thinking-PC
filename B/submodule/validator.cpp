#include <stdio.h>
#include <assert.h>
#include <algorithm>
using namespace std;

typedef long long lli;

int a[1024][1024], n;

int main() {
    scanf("%d", &n);
    assert(__builtin_popcount(n) == 1 && 2 <= n && n <= 1024);

    lli res = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &a[i][j]);
            assert(1 <= a[i][j] && a[i][j] <= 100000);
            res += a[i][j];
        }
    }

    printf("%lld\n", res);
    return 0;
}
