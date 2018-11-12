#include <stdio.h>
#include <string.h>
#include <queue>
#include <utility>
#include <assert.h>
using namespace std;

typedef pair<int, int> ip;

int n = 10, m = 9;
int dr[8] = { -3,-3,-2,2,3,3,2,-2 };
int dc[8] = { -2,2,3,3,2,-2,-3,-3 };
int d[10][9];
int c[8][2][2] = {
    {{-1,0},{-2,-1}},{{-1,0},{-2,1}},{{0,1},{-1,2}},{{0,1},{1,2}},{{1,0},{2,1}},{{1,0},{2,-1}},{{0,-1},{-1,-2}},{{0,-1},{1,-2}}
};

bool pos(int r, int c) {
    return 0 <= r && r < n && 0 <= c && c < m;
}

int tr, tc;

void bfs(int sr, int sc) {
    memset(d, -1, sizeof(d));
    queue<ip> q;
    q.push(ip(sr, sc));
    d[sr][sc] = 0;

    while (!q.empty() && d[tr][tc] < 0) {
        int cr = q.front().first
        int cc = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++) {
            int nr = cr + dr[i]
            int nc = cc + dc[i];
            if (pos(nr, nc) && d[nr][nc] < 0) {
                bool ok = true;
                for (int t = 0; t < 2; t++) {
                    int nr = cr + c[i][t][0]
                    int nc = cc + c[i][t][1];
                    if (!pos(nr, nc) || (tr == nr && tc == nc)) {
                        ok = false;
                        break;
                    }
                }

                if (!ok)
                    continue;
                d[nr][nc] = d[cr][cc] + 1;
                q.push(ip(nr, nc));
            }
        }
    }
}

int main() {
    int sr, sc;
    scanf("%d %d %d %d", &sr, &sc, &tr, &tc);
    assert(0 <= sr && sr <= 9 && 0 <= sc && sc <= 8);
    assert(sr != sc || tr != tc);
    assert((0 <= tr && tr <= 2 && 3 <= tc && tc <= 5) || (7 <= tr && tr <= 9 && 3 <= tc && tc <= 5));

    bfs(sr, sc);
    printf("%d\n", d[tr][tc]);
    return 0;
}
