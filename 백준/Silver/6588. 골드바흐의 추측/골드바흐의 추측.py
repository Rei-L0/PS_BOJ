import sys

arr = [False]*2+[True]*(10**6)
for i in range(2, int(len(arr)**0.5)):
    if arr[i]:
        for j in range(i+i, len(arr), i):
            arr[j] = False

while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break
    for i in range(3, n, 2):
        if arr[i] and arr[n-i]:
            print(f'{n} = {i} + {n-i}')
            break
