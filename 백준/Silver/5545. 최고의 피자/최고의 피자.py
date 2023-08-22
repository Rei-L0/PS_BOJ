import sys

n = int(sys.stdin.readline().rstrip())
a, b = map(int, sys.stdin.readline().rstrip().split())
c = int(sys.stdin.readline().rstrip())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
pizza = c
kcal = a
answer = pizza // kcal
data.sort(reverse=True)

for i in data:
    if answer <= (pizza + i) // (kcal + b):
        answer = (pizza + i) // (kcal + b)
        pizza += i
        kcal += b
print(answer)
