#include <stdio.h>
#include <assert.h>

int a[200001], n, m, s[200001];

int main() {
    scanf("%d %d", &n, &m);
    assert(1 <= n && n <= 200000 && 1 <= m && m <= 200000);

    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        assert(1 <= a[i] && a[i] <= 10000);
        s[i] = s[i - 1] + a[i];
    }

    while (m--) {
        long long t;
        scanf("%lld", &t);
        assert(1 <= t && t <= 2000000000);

        if (s[1] > t)
            puts("0");
        else if (s[n] <= t)
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
