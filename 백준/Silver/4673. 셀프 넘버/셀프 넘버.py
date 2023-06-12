num = [False] * 10001

for i in range(1, len(num)):
    dn = i
    while i != 0:
        dn += i % 10
        i = i // 10
    if dn <= 10000:
        num[dn] = True

for i in range(1, len(num)):
    if not num[i]:
        print(i)
