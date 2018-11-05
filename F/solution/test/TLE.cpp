#include <stdio.h>

int image[1001][1001];

int main() {
    int R, C, Q;
    scanf("%d %d %d", &R, &C, &Q);

    for (int r = 1; r <= R; r++)
        for (int c = 1; c <= C; c++)
            scanf("%d", &image[r][c]);

    int r1, c1, r2, c2;
    while (Q-- > 0) {
        scanf("%d %d %d %d\n", &r1, &c1, &r2, &c2);

        int n = (r2 - r1 + 1) * (c2 - c1 + 1);
        int sum = 0;
        for (int r = r1; r <= r2; r++)
            for (int c = c1; c <= c2; c++)
                sum += image[r][c];

        printf("%d\n", sum / n);
    }
}
