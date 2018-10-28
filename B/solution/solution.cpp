#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    long sum = 0;
    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
            int n;
            cin >> n;
            sum += n;
        }
    }

    cout << sum;
    return 0;
}
