from collections import deque

n, s = map(int, input().split())

data = list(map(int, input().split()))

ans = []
csum = 0
end = 0
cnt = 0
for start in range(n):
    while csum < s and end < n:
        csum += data[end]
        end += 1
        cnt += 1
    if csum >= s:
        ans.append(cnt)
    csum -= data[start]
    cnt -= 1

print(min(ans) if ans else 0)
