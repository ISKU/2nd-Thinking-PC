import sys

N, M = map(int, sys.stdin.readline().split())
queue = list(map(int, sys.stdin.readline().split()))

psum = [ 0 for i in range(N + 1) ]
for i in range(1, N + 1):
    psum[i] = psum[i - 1] + queue[i - 1]

for i in range(M):
    T = int(sys.stdin.readline())

    i = 0
    while (i <= N):
        if (psum[i] > T):
            break;
        i += 1

    print(i - 1)
