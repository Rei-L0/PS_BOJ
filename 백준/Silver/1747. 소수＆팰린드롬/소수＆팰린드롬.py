# 1747

n = int(input())
check_num = [False, False] + [True] * 12345678
prime = []

for i in range(2, len(check_num)):
    if check_num[i]:
        prime.append(i)
        for j in range(i * 2, len(check_num), i):
            check_num[j] = False
for i in prime:
    if i >= n:
        x = str(i)
        if x == x[::-1][: len(x)]:
            print(i)
            break
