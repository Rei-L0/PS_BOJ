n = int(input())


def check(tmp, idx):
    global min_ans
    global max_ans
    if idx == (n - 1):
        min_ans = min(tmp, min_ans)
        max_ans = max(tmp, max_ans)
        return

    temp = tmp

    for i in range(4):
        if oper[i] > 0:
            oper[i] -= 1
            tmp = calc(i, idx + 1, temp)
            check(tmp, idx + 1)
            oper[i] += 1


def calc(num, idx, msum):
    if num == 0:
        return msum + data[idx]
    elif num == 1:
        return msum - data[idx]
    elif num == 2:
        return msum * data[idx]
    else:
        tmp = abs(msum) // data[idx]
        if msum < 0:
            return -tmp
        return tmp


data = list(map(int, input().split()))
# +, -, *, //
# 음수 나누기 양수로 나누고 음수로 변환
oper = list(map(int, input().split()))
min_ans = 10**15
max_ans = -(10**15)
check(data[0], 0)

print(max_ans)
print(min_ans)
