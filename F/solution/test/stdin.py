import sys

R, C, Q = map(int, sys.stdin.readline().split())

psum = [[0 for cols in range(C + 1)] for rows in range(R + 1)]

for r in range(1, R + 1):
    cols = list(map(int, sys.stdin.readline().split()))
    for c in range(1, C + 1):
        psum[r][c] = cols[c - 1] + psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1]

for q in range(Q):
    r1, r2, c1, c2 = map(int, sys.stdin.readline().split())
    
    sum = psum[r2][c2] - psum[r1 - 1][c2] - psum[r2][c1 - 1] + psum[r1 - 1][c1 - 1]
    n = (r2 - r1 + 1) * (c2 - c1 + 1)

    print(sum // n)
