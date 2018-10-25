import sys

def lowerBound(array, value):
    l = 0
    r = len(array) - 1

    while (l < r):
        mid = (l + r) // 2
        
        if (array[mid] < value):
            l = mid + 1
        else:
            r = mid

    return l if (array[l] <= value) else l - 1


N, M = map(int, sys.stdin.readline().split())
queue = list(map(int, sys.stdin.readline().split()))

psum = [ 0 for i in range(N + 1) ]
for i in range(1, N + 1):
    psum[i] = psum[i - 1] + queue[i - 1]

for i in range(M):
    T = int(sys.stdin.readline())
    print(lowerBound(psum, T))
