sy, sm, sd = map(int, input().split("-"))
t = int(input())
ans = 0
for i in range(t):
    y, m, d = map(int, input().split("-"))
    if y > sy:
        ans += 1
    elif y == sy:
        if m > sm:
            ans += 1
        elif m == sm:
            if d >= sd:
                ans += 1

print(ans)
