#include <stdio.h>

int a[200001], n, m, s[200001];

int main() {
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        s[i] = s[i - 1] + a[i];
    }

    while (m--) {
        long long t;
        scanf("%lld", &t);

        if (s[n] <= t)
            printf("%d\n", n);
        else {
            int lo = 1, hi = n;

            while (lo + 1 < hi) {
                int mid = (lo + hi) / 2;

                if (s[mid] <= t) 
                    lo = mid;
                else 
                    hi = mid;
            }

            printf("%d\n", lo);
        }
    }
    return 0;
}
