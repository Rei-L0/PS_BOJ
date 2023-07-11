from collections import deque


def bfs(s):
    queue = deque()
    queue.append(s)

    while queue:
        x = queue.popleft()
        if x == k:
            print(time[x])
            return
        for i in (x - 1, x + 1, x * 2):
            if -1 < i < 10**6 + 1 and not time[i]:
                time[i] = time[x] + 1
                queue.append(i)


n, k = map(int, input().split())

time = [0] * (10**6 + 1)
bfs(n)
