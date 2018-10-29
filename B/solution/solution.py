N = int(input())

sum = 0
for y in range(0, N):
    for i in input().split():
       sum += int(i)

print(sum)
