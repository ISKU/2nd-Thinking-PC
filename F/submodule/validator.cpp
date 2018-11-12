#include <iostream>
#include <string>
#include <algorithm>
#include <assert.h>
using namespace std;

int c[26], n;
string t, s[16];
int ci[16];

int main() {
    cin >> t >> n;
    assert(1 <= t.size() && t.size() <= 10);

    for (int i = 0; i < t.size(); i++)
        assert('A' <= t[i] && t[i] <= 'Z');
    assert(1 <= n&&n <= 16);

    for (int i = 0; i < n; i++) {
        cin >> ci[i] >> s[i];
        assert(10000 <= ci[i] && ci[i] <= 100000);
        assert(1 <= s[i].size() && s[i].size() <= 50);

        for (int j = 0; j < s[i].size(); j++)
            assert('A' <= s[i][j] && s[i][j] <= 'Z');
    }

    for (int i = 0; i < t.size(); i++)
        c[t[i] - 'A']++;

    int res = (1 << 30);
    for (int i = 1; i < (1 << n); i++) {
        int p[26] = { 0 }
        int sum = 0;

        for (int j = 0; j < n; j++) {
            if (i&(1 << j)) {
                for (int k = 0; k < s[j].size(); k++)
                    p[s[j][k] - 'A']++;
                sum += ci[j];
            }
        }

        bool ok = true;
        for (int j = 0; j < 26; j++) {
            if (p[j] < c[j]) {
                ok = false;
                break;
            }
        }

        if (ok && sum < res) 
            res = sum;
    }

    if (res == (1 << 30))
        res = -1;
    cout << res << "\n";
    return 0;
}
