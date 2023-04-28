N = int(input())
chk = 0
for _ in range(N):
    x = int(input())
    if x == 1:
        chk += 1

if N-chk > chk:
    print('Junhee is not cute!')
else:
    print('Junhee is cute!')
