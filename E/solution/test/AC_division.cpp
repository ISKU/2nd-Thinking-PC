#include <stdio.h>
#include <math.h>

int n, m, q;
int s[1001][1001];
int a[1001][1001];

int main() {
    scanf("%d %d %d", &n, &m, &q);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf("%d", &a[i][j]);
            s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
        }
    }

    while (q--) {
        int r1, c1, r2, c2;
        scanf("%d %d %d %d", &r1, &c1, &r2, &c2);
        printf("%.0f\n", floor((s[r2][c2] - s[r1 - 1][c2] - s[r2][c1 - 1] + s[r1 - 1][c1 - 1] * 1.0) / ((1.0 * r2 - r1 + 1) * (1.0 * c2 - c1 + 1))));
    }
    return 0;
}
