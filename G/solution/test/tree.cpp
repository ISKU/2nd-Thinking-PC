#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

const int INF = 123456789;

typedef struct Book {
    int C;
    string W;
    int letter[26];
} Book;

int letter[26], cnt[26];
Book books[16];
int N, answer;

void dfs(int idx, int cost) {
    if (idx >= N)
        return;

    dfs(idx + 1, cost);

    cost += books[idx].C;
    for (int i = 0; i < 26; i++)
        cnt[i] += books[idx].letter[i];

    bool check = true;
    for (int i = 0; i < 26; i++) {
        if (cnt[i] < letter[i]) {
            check = false;
            break;
        }
    }
    if (check)
        answer = min(answer, cost);

    dfs(idx + 1, cost);

    cost -= books[idx].C;
    for (int i = 0; i < 26; i++)
        cnt[i] -= books[idx].letter[i];
}

int main() {
    string T;
    cin >> T;
    for (int i = 0; i < T.size(); i++)
        letter[T[i] - 'A']++;

    cin >> N;
    for (int i = 0; i < N; i++) {
        Book book;
        cin >> book.C >> book.W;

        memset(book.letter, 0, sizeof(book.letter));
        for (int j = 0; j < book.W.size(); j++)
            book.letter[book.W[j] - 'A']++;

        books[i] = book;
    }

    answer = INF;
    dfs(0, 0);

    if (answer == INF)
        cout << -1;
    else
        cout << answer;

    return 0;
}
