T = input()
letter = [ 0 for i in range(26) ]
for i in range(len(T)):
   letter[ord(T[i]) - ord('A')] += 1

N = int(input())
books = []
for i in range(N):
    C, W = input().split()

    temp = [ 0 for i in range(26) ]
    for j in range(len(W)):
        temp[ord(W[j]) - ord('A')] += 1

    books.append((int(C), W, temp))

answer = 123456789
size = 1 << N
for n in range(size):
    cost = 0
    count = [ 0 for i in range(26) ]

    idx = 0
    d = 1
    while True:
        if d > n:
            break

        if (n & d) == d:
            cost += books[idx][0]
            for i in range(26):
                count[i] += books[idx][2][i]

        idx += 1
        d <<= 1

    check = True
    for i in range(26):
        if count[i] < letter[i]:
            check = False
            break
    if check:
        answer = min([answer, cost])

if answer == 123456789:
    print(-1)
else:
    print(answer)
