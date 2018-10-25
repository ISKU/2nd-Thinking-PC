import sys

array = [[False for rows in range(1025)] for cols in range(1025)]
array[1][1] = True
size = 1
while (size <= 512):
    for y in range(1, size + 1):
        for x in range(1, size + 1):
            array[y][x + size] = array[y][x];
            array[y + size][x] = array[y][x];

    size *= 2

N = int(input())
if N == 0:
    print('*')
    sys.exit(0)

for y in range(1, (1 << N) + 1):
    end = 1 << N
    for x in range(end, 0, -1):
        if array[y][x]:
            end = x
            break

    for x in range(1, end + 1):
        print('*' if array[y][x] else ' ', end = '')
    print()
