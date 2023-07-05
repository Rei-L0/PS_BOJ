prime = [False, False] + [True] * 1234567

for i in range(2, len(prime)):
    if prime[i]:
        for j in range(i * 2, len(prime), i):
            prime[j] = False

while True:
    n = int(input())
    if n == 0:
        break
    ans = 0
    for i in range(n + 1, 2 * n + 1):
        if prime[i]:
            ans += 1
    print(ans)
