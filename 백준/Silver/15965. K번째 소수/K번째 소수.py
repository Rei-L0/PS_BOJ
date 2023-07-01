prime = [True] * (10**7 + 1)
ans = [0]
k = int(input())

for i in range(2, len(prime)):
    if prime[i]:
        ans.append(i)
        for j in range(i * 2, len(prime), i):
            prime[j] = False

print(ans[k])
