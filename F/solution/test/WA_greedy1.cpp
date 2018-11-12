#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

class p {
public:
    string s;
    int c;
};

bool cmp(const p &i, const p &j) {
    return i.c < j.c;
}

string t;
int n;
p list[16];
int c[26], m[26];

int main() {
    cin >> t >> n;

    for (int i = 0; i < n; i++)
        cin >> list[i].c >> list[i].s;
    for (int i = 0; i < t.size(); i++)
        c[t[i] - 'A']++;

    sort(list, list + n, cmp);
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += list[i].c;

        for (int j = 0; j < list[i].s.size(); j++)
            m[list[i].s[j] - 'A']++;

        bool fin = true;
        for (int j = 0; j < 26; j++) {
            if (m[j] < c[j]) {
                fin = false;
                break;
            }
        }

        if (fin) {
            cout << sum << "\n";
            return 0;
        }
    }
    cout << "-1\n";
    return 0;
}
