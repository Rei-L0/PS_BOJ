t = int(input())

prime = [False, False] + [True] * 10000

for i in range(2, len(prime)):
    if prime[i]:
        for j in range(i * 2, len(prime), i):
            prime[j] = False

for _ in range(t):
    n = int(input())
    for i in range(n // 2, len(prime)):
        if prime[i] and prime[n - i]:
            print(f"{n-i} {i}")
            break
