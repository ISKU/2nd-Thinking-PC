#include <stdio.h>
#include <vector>
using namespace std;

int queue[200002];
vector<int> psum;

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    for (int i = 1; i <= N; i++)
        scanf("%d", &queue[i]);
    
    for (int i = 0, sum = 0; i <= N; i++) {
        sum += queue[i];
        psum.push_back(sum);
    }

    while (M-- > 0) {
        int T;
        scanf("%d", &T);

        int i = 0;
        for (; i <= N; i++)
            if (psum[i] > T)
                break;

        printf("%d\n", i - 1);
    }

    return 0;
}
