import queue;

dy = [ -3, -3, -2, 2, 3, 3, 2, -2 ]
dx = [ -2, 2, 3, 3, 2, -2, -3, -3 ]

def bfs():
    q = queue.Queue()
    visited = [[False for rows in range(9)] for cols in range(10)]

    q.put((R1, C1, 0))
    visited[R1][C1] = True   
    
    while not q.empty():
        u = q.get()
        if (u[0] == R2 and u[1] == C2):
            return u[2]

        for i in range(0, 8):
            y = u[0] + dy[i]
            x = u[1] + dx[i]
            if (y < 0 or y >= 10 or x < 0 or x >= 9 or visited[y][x]):
                continue

            q.put((y, x, u[2] + 1))
            visited[y][x] = True

    return -1

R1, C1 = map(int, input().split())
R2, C2 = map(int, input().split())
print(bfs())
