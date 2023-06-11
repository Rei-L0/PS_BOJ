p = int(input())

for _ in range(p):
    child = list(map(int, input().split()))
    tc, child = child[0], child[1:]
    ans = 0
    ans_list = list()
    for i in range(len(child)):
        if not ans_list:
            ans_list.append(child[i])
        else:
            for j in range(len(ans_list)):
                if ans_list[j] > child[i]:
                    ans_list.insert(j, child[i])
                    ans += len(ans_list) - j - 1
                    break
                if j == len(ans_list) - 1:
                    ans_list.append(child[i])
    print(f"{tc} {ans}")
