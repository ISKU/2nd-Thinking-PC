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
        
        int answer = lower_bound(psum.begin(), psum.end(), T) - psum.begin();
        if (psum[answer] != T)
            answer--;
        printf("%d\n", answer);
    }

    return 0;
}
