tall = list()
x = list()

for _ in range(9):
    a = int(input())
    tall.append(a)

tall.sort()
chk = 0

res = sum(tall) - 100
for i in range(len(tall)):
    for j in range(i + 1, len(tall)):
        if tall[i] + tall[j] == res:
            x.append(tall[i])
            x.append(tall[j])
            chk = 1
            break
    if chk == 1:
        break

for i in tall:
    if i not in x:
        print(i)
