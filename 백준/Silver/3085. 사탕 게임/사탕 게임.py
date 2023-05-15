def check(data):
    max_cnt = 0
    for i in range(len(data)):
        cnt = 1
        for j in range(1, len(data)):
            if data[i][j - 1] == data[i][j]:
                cnt += 1
            else:
                max_cnt = max(max_cnt, cnt)
                cnt = 1
        max_cnt = max(max_cnt, cnt)
    for i in range(len(data)):
        cnt = 1
        for j in range(1, len(data)):
            if data[j - 1][i] == data[j][i]:
                cnt += 1
            else:
                max_cnt = max(max_cnt, cnt)
                cnt = 1
        max_cnt = max(max_cnt, cnt)
    return max_cnt


N = int(input())

candy = [list(input()) for _ in range(N)]

ans = 0
# 사탕 교환
for i in range(N):
    for j in range(1, N):
        candy[i][j - 1], candy[i][j] = candy[i][j], candy[i][j - 1]
        ans = max(ans, check(candy))
        candy[i][j - 1], candy[i][j] = candy[i][j], candy[i][j - 1]
        candy[j - 1][i], candy[j][i] = candy[j][i], candy[j - 1][i]
        ans = max(ans, check(candy))
        candy[j - 1][i], candy[j][i] = candy[j][i], candy[j - 1][i]

print(ans)
