#include <stdio.h>

int a[200001], n, m, s[200001];

int main() %{
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
            int sum = 0, r = n;

            for (int i = 1; i <= n; i++) {
                if (sum + a[i] > t) {
                    r = i - 1; 
                    break;
                }
                else
                    sum += a[i];
            }

            printf("%d\n", r);
        }
    }
    return 0;
}
