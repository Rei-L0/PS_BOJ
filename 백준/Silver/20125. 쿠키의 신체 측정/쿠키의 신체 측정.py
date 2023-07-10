n = int(input())
data = [list(input()) for _ in range(n)]

hx, hy = 0, 0
la = ra = core = lr = rr = 0

for i in range(n):
    for j in range(n):
        if data[i][j] == "*":
            hy = i + 1
            hx = j
            break
    if hx != 0 and hy != 0:
        break

# 팔
for i in range(hx - 1, -1, -1):
    if data[hy][i] == "*":
        la += 1
    else:
        break
for i in range(hx + 1, n):
    if data[hy][i] == "*":
        ra += 1
    else:
        break

# 허리
cx = hx
cy = 0
for i in range(hy + 1, n):
    if data[i][hx] == "*":
        core += 1
        cy = i
    else:
        break

# 다리
for i in range(cy + 1, n):
    if data[i][cx - 1] == "*":
        lr += 1
    else:
        break
for i in range(cy + 1, n):
    if data[i][cx + 1] == "*":
        rr += 1
    else:
        break

print(f"{hy+1} {hx+1}")
print(f"{la} {ra} {core} {lr} {rr}")
