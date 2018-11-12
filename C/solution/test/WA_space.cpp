#include <stdio.h>

int main() {
    bool array[1025][1025];
    for (int i = 0; i < 1025; i++)
        for (int j = 0; j < 1025; j++)
            array[i][j] = 0;
    array[1][1] = 1;

    for (int size = 1; size <= 512; size *= 2) {
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                array[y][x + size] = array[y][x];
                array[y + size][x] = array[y][x];
            }
        }
    }

    int N;
    scanf("%d", &N);
    if (N == 0) {
        printf("*");
        return 0;
    }

    for (int y = 1; y <= (1 << N); y++) {
        for (int x = 1; x <= (1 << N); x++)
            printf("%s", array[y][x] ? "*" : " ");
        printf("\n");
    }

    return 0;
}
