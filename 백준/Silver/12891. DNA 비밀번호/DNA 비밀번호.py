s, p = map(int, input().split())

data = list(input())
inc = dict()
data2 = list(map(int, input().split()))
chk = dict()
dna = ["A", "C", "G", "T"]

for i in range(4):
    inc[dna[i]] = data2[i]
    chk[dna[i]] = 0

for i in range(p):
    chk[data[i]] += 1

start = 0
end = p - 1
ans = 0
while True:
    x = 0
    for i in range(4):
        if chk[dna[i]] >= inc[dna[i]]:
            x += 1
    if x == 4:
        ans += 1
    chk[data[start]] -= 1
    start += 1
    end += 1
    if end > s - 1:
        break
    chk[data[end]] += 1

print(ans)
