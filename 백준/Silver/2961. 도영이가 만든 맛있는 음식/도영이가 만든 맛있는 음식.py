import copy


def brute(s, b, idx):
    if idx == n:
        if s != 1 and b != 0:
            ans.append(abs(s - b))
        return
    brute(s, b, idx + 1)
    brute(s * taste[idx][0], b + taste[idx][1], idx + 1)


n = int(input())

taste = [list(map(int, input().split())) for _ in range(n)]
ans = []

brute(1, 0, 0)
print(min(ans))
