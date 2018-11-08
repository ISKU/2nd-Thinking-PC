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

int letter[26];
Book books[16];

int main() {
    string T;
    cin >> T;
    for (int i = 0; i < T.size(); i++)
        letter[T[i] - 'A']++;

    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        int C;
        string W;
        cin >> C >> W;

        Book book;
        book.C = C;
        book.W = W;
        memset(book.letter, 0, sizeof(book.letter));
        for (int j = 0; j < W.size(); j++)
            book.letter[W[j] - 'A']++;

        books[i] = book;
    }

    int answer = INF;
    int size = 1 << N;
    for (int n = 1; n < size; n++) {
        int cost = 0;
        int count[26];
        memset(count, 0, sizeof(count));

        for (int d = 1, idx = 0; d <= n; d <<= 1, idx++) {
            if ((n & d) != d)
                continue;

            cost += books[idx].C;
            for (int i = 0; i < 26; i++)
                count[i] += books[idx].letter[i];
        }

        bool check = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] < letter[i]) {
                check = false;
                break;
            }
        }
        if (check)
            answer = min(answer, cost);
    }

    if (answer == INF)
        cout << "-1";
    else
        cout << answer;

    return 0;
}
