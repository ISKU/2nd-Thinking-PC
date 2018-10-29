#include <stdio.h>
#include <queue>
using namespace std;

int dy[] = { -3, -3, -2, 2, 3, 3, 2, -2 };
int dx[] = { -2, 2, 3, 3, 2, -2, -3, -3 };

typedef struct Piece {
    int y, x, count;
} Piece;

Piece sang, king;

int bfs() {
    queue<Piece> q;
    bool visited[10][9];
    for (int y = 0; y < 10; y++)
        for (int x = 0; x < 9; x++)
            visited[y][x] = false;

    q.push(sang);
    visited[sang.y][sang.x] = true;

    while (!q.empty()) {
        Piece u = q.front();
        q.pop();
        if (u.y == king.y && u.x == king.x)
            return u.count;

        for (int i = 0; i < 8; i++) {
            int y = u.y + dy[i];
            int x = u.x + dx[i];
            if (y < 0 || y >= 10 || x < 0 || x >= 9 || visited[y][x])
                continue;

            Piece v = { y, x, u.count + 1 };
            q.push(v);
            visited[y][x] = true;
        }
    }

    return -1;
}

int main() {
    int R1, C1, R2, C2;
    scanf("%d %d %d %d", &R1, &C1, &R2, &C2);

    sang = { R1, C1, 0 };
    king = { R2, C2, 0 };

    printf("%d", bfs());
    return 0;
}
