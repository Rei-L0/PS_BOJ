N = int(input())
a, b, ans = 1, 2, 0
while a != b :
    if b ** 2 - a ** 2 == N :
        ans += 1
        b += 1
    elif b ** 2 - a ** 2 > N : a += 1
    else : b += 1
print(ans)