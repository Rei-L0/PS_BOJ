a, b = map(int, input().strip().split(' '))

for _ in range(b):
    star=''
    for _ in range(a):
        star+='*'
    print(''.join(star))