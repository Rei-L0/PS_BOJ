n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort(reverse=True)
b.sort()
print(sum(map(lambda x, y: x * y, a, b)))
