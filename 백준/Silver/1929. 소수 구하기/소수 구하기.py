def prime():
    arr = [True]*(10**6+1)
    for i in range(2, int(len(arr)**0.5)):
        if arr[i]:
            for j in range(i+i, len(arr), i):
                arr[j] = False
    return arr


pri = prime()
pri[0], pri[1] = False, False
n, m = list(map(int, input().split()))
for i in range(n, m+1):
    if pri[i]:
        print(i)
