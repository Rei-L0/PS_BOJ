n, m = map(int, input().split())

n_p = [input() for _ in range(n)]
m_p = [input() for _ in range(m)]

nm_p = list(set(n_p) & set(m_p))
nm_p.sort()
print(len(nm_p))
for i in nm_p:
    print(i)
