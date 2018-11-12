#include <stdio.h>
#include <assert.h>

int n, m, q;
int s[1001][1001];
int a[1001][1001];

int main() {
    scanf("%d %d %d", &n, &m, &q);
    assert(1 <= n && n <= 1000 && 1 <= m && m <= 1000 && 1 <= q && q <= 10000);
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf("%d", &a[i][j]);
            assert(1 <= a[i][j] && a[i][j] <= 1000);
            s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
        }
    }

    while (q--) {
        int r1, c1, r2, c2;
        scanf("%d %d %d %d", &r1, &c1, &r2, &c2);
        assert(1 <= r1 && r1 <= r2 && r2 <= n && 1 <= c1 && c1 <= c2 && c2 <= m);
        printf("%d\n", (s[r2][c2] - s[r1 - 1][c2] - s[r2][c1 - 1] + s[r1 - 1][c1 - 1]) / ((r2 - r1 + 1) * (c2 - c1 + 1)));
    }
    return 0;
}
