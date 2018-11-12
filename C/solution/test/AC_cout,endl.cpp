#include <iostream>
using namespace std;

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
    cin >> N;
    if (N == 0) {
        printf("*");
        return 0;
    }

    for (int y = 1; y <= (1 << N); y++) {
        int end = 1 << N;
        for (int x = end; x >= 1; x--) {
            if (array[y][x]) {
                end = x;
                break;
            }
        }

        for (int x = 1; x <= end; x++)
            cout << (array[y][x] ? "*" : " ");
        cout << endl;
    }

    return 0;
}
