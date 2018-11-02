import sys

R, C, Q = map(int, sys.stdin.readline().split())

image = [[0 for cols in range(C + 1)] for rows in range(R + 1)]
for r in range(1, R + 1):
    cols = list(map(int, sys.stdin.readline().split()))
    for c in range(1, C + 1):
        image[r][c] = cols[c - 1]

for q in range(Q):
    r1, r2, c1, c2 = map(int, sys.stdin.readline().split())

    n = (r2 - r1 + 1) * (c2 - c1 + 1)
    sum = 0
    for r in range(r1, r2 + 1):
        for c in range(c1, c2 + 1):
            sum += image[r][c]

    print(sum // n)
