def l_check(x, l):
    chk = [False] * len(x)
    for i in range(1, len(x)):
        if abs(x[i - 1] - x[i]) > 1:
            return False
        if l == 1:
            if x[i - 1] > x[i]:
                if chk[i]:
                    return False
                chk[i] = True
            if x[i - 1] < x[i]:
                if chk[i - 1]:
                    return False
                chk[i - 1] = True
        else:
            if x[i - 1] < x[i]:
                cnt = 0
                if i < l:
                    return False
                for j in range(i - 1, 0, -1):
                    if x[j - 1] == x[j] and not chk[j - 1]:
                        cnt += 1
                        chk[j - 1] = True
                        chk[j] = True
                    else:
                        return False
                    if cnt == (l - 1):
                        break
            if x[i - 1] > x[i]:
                cnt = 0
                if len(x) - i < l:
                    return False
                for j in range(i, len(x) - 1):
                    if x[j + 1] == x[j] and not chk[j + 1]:
                        cnt += 1
                        chk[j + 1] = True
                        chk[j] = True
                    else:
                        return False
                    if cnt == (l - 1):
                        break
    return True


n, l = map(int, input().split())

arr = []
check = [[False for _ in range(n)] for _ in range(n)]
for _ in range(n):
    arr.append(list(map(int, input().split())))

ans = 0

arr2 = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    for j in range(n):
        arr2[i][j] = arr[j][i]

for idx in arr:
    if l_check(idx, l):
        ans += 1
for idx in arr2:
    if l_check(idx, l):
        ans += 1
print(ans)
