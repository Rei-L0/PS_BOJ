n = int(input())

prime = [True for _ in range(n + 1)]
prime_list = list()
for i in range(2, n + 1):
    if prime[i]:
        prime_list.append(i)
        for j in range(i * 2, n + 1, i):
            prime[j] = False
end = 0
csum = 0
ans = 0

for start in range(len(prime_list)):
    while csum < n and end < len(prime_list):
        csum += prime_list[end]
        end += 1
    if csum == n:
        ans += 1
    csum -= prime_list[start]

print(ans)
