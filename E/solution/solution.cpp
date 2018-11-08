#include <stdio.h>

int psum[1001][1001];

int main() {
    int R, C, Q;
    scanf("%d %d %d", &R, &C, &Q);

    int K;
    for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
            scanf("%d", &K);
            psum[r][c] = K + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];
        }
    }

    int r1, c1, r2, c2;
    while (Q-- > 0) {
        scanf("%d %d %d %d\n", &r1, &c1, &r2, &c2);

        int sum = psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1];
        int n = (r2 - r1 + 1) * (c2 - c1 + 1);

        printf("%d\n", sum / n);
    }
}
