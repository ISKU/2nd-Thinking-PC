#include <iostream>
using namespace std;

int psum[1001][1001];

int main() {
    int R, C, Q;
    cin >> R >> C >> Q;

    int K;
    for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
            cin >> K;
            psum[r][c] = K + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];
        }
    }

    int r1, c1, r2, c2;
    while (Q-- > 0) {
        cin >> r1 >> c1 >> r2 >> c2;

        int sum = psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1];
        int n = (r2 - r1 + 1) * (c2 - c1 + 1);

        cout << (sum / n) << endl;
    }
}
