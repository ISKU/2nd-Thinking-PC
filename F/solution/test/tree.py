T = input()
letter = [ 0 for i in range(26) ]
for i in range(len(T)):
    letter[ord(T[i]) - ord('A')] += 1

N = int(input())
books = []
for i in range(N):
    C, W = input().split()

    temp = [ 0 for j in range(26) ]
    for j in range(len(W)):
        temp[ord(W[j]) - ord('A')] += 1

    books.append((int(C), W, temp))

count = [ 0 for i in range(26) ]
answer = 123456789

def dfs(idx, cost):
    global answer
    if (idx >= N):
        return

    dfs(idx + 1, cost)
    
    cost += books[idx][0]
    for i in range(26):
        count[i] += books[idx][2][i]

    check = True
    for i in range(26):
        if count[i] < letter[i]:
            check = False
            break
    if check:
        answer = min([answer, cost])

    dfs(idx + 1, cost)

    cost -= books[idx][0]
    for i in range(26):
        count[i] -= books[idx][2][i]

dfs(0, 0)
if answer == 123456789:
    print(-1)
else:
    print(answer)
