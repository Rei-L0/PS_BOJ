def password(jcnt, mcnt, tmp, idx):
    if len(tmp) == l:
        if jcnt >= 2 and mcnt >= 1:
            print("".join(tmp))
        return
    for i in range(c):
        if i not in tmp and idx < i:
            tmp.append(data[i])
            if data[i] in mo:
                password(jcnt, mcnt + 1, tmp, i)
            else:
                password(jcnt + 1, mcnt, tmp, i)
            tmp.pop()


l, c = map(int, input().split())
data = list(input().split())
data.sort()
mo = ["a", "e", "i", "o", "u"]

password(0, 0, [], -1)
