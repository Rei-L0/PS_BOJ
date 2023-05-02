N = int(input())
div = list(map(int, input().split()))
div.sort()

if len(div) % 2 == 0:
    print(div[0]*div[-1])
else:
    print(div[(len(div)//2)]**2)
