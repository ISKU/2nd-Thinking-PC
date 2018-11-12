#include <stdio.h>
#include <math.h>
#include <map>
#include <utility>
using namespace std;

typedef pair<int, int> ip;
map<ip, int> d[1001][1001];

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

        if (d[r1][r2].count(ip(c1, c2))) {
            printf("%d\n", d[r1][r2][ip(c1, c2)]);
            continue;
        }

        int sum = 0;
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                sum += a[i][j];

        d[r1][r2][ip(c1, c2)] = sum / ((r2 - r1 + 1) * (c2 - c1 + 1));
        printf("%d\n", sum / ((r2 - r1 + 1) * (c2 - c1 + 1)));
    }
    return 0;
}
