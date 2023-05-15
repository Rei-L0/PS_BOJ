E, S, M = map(int, input().split())

e, s, m = 1, 1, 1
ans = 1
while True:
    if e == E and s == S and m == M:
        print(ans)
        break
    ans += 1
    e, s, m = e + 1, s + 1, m + 1
    if e > 15:
        e = e % 15
    if s > 28:
        s = s % 28
    if m > 19:
        m = m % 19
