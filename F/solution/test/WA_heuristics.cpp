#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int c[26], n, p[26];
string t, s[16];
int ci[16], res = (1 << 30);

void dfs(int k, int sum) {
    if (sum >= res)
        return;

    bool fin = true;
    for (int i = 0; i < 26; i++) {
        if (p[i] < c[i]) {
            fin = false;
            break;
        }
    }

    if (fin) {
        if (sum < res)
            res = sum;
        return;
    }
    if (k == n)
        return;

    for (int i = 0; i < s[k].size(); i++)
        p[s[k][i] - 'A']++;

    dfs(k + 1, sum + ci[k]);
    dfs(k + 1, sum);
}

int main() {
    cin >> t >> n;

    for (int i = 0; i < n; i++)
        cin >> ci[i] >> s[i];
    for (int i = 0; i < t.size(); i++)
        c[t[i] - 'A']++;

    dfs(0, 0);
    if (res == (1 << 30))
        res = -1;
    cout << res << "\n";
    return 0;
}
