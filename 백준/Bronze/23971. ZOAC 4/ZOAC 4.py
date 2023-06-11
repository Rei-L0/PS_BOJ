h, w, n, m = map(int, input().split())

if (h % (n + 1)) > 0 and (w % (m + 1)) > 0:
    ans = ((h // (n + 1)) + 1) * ((w // (m + 1)) + 1)
elif (h % (n + 1)) > 0:
    ans = ((h // (n + 1)) + 1) * (w // (m + 1))
elif (w % (m + 1)) > 0:
    ans = (h // (n + 1)) * ((w // (m + 1)) + 1)
else:
    ans = (h // (n + 1)) * (w // (m + 1))
print(ans)
