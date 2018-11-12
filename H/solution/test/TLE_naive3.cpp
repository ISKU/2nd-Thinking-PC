#include <stdio.h>
#include <algorithm>
using namespace std;

int a[200001], n, m, s[200001];

int main() {
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        s[i] = s[i - 1] + a[i];
    }

    while (m--) {
        int t;
        scanf("%d", &t);

        if (s[1] > t)
            puts("0");
        else if (s[n] <= t)
            printf("%d\n", n);
        else {
            bool found = false;
            int sum = 0, r;

            for (int i = 1; i <= min(n, 501); i++) {
                if (sum + a[i] > t) {
                    found = true; r = i - 1;
                    break;
                }
                else
                    sum += a[i];
            }
            if (found) {
                printf("%d\n", r);
                continue;
            }

            sum = s[n];
            for (int i = n; i >= max(n - 501, 1); i--) {
                sum -= a[i];

                if (sum <= t) {
                    found = true; r = i - 1;
                    break;
                }
            }
            if (found) {
                printf("%d\n", r);
                continue;
            }

            sum = 0;
            for (int i = 1; i <= n; i++) {
                if (sum + a[i] > t) {
                    printf("%d\n", i - 1);
                    break;
                }
                else
                    sum += a[i];
            }
        }
    }
    return 0;
}
