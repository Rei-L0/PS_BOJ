from collections import deque

n = int(input())
data = [int(input()) for _ in range(n)]
plus = []
minus = []
for i in sorted(data):
    if i <= 0:
        minus.append(i)
    else:
        plus.append(i)

answer = 0
if plus:
    while plus:
        x = plus.pop()
        if plus:
            y = plus.pop()
            if x > 1 and y > 1:
                answer += x * y
            else:
                answer += x + y
        else:
            answer += x
if minus:
    minus.sort(reverse=True)
    while minus:
        x = minus.pop()
        if minus:
            y = minus.pop()
            answer += x * y
        else:
            answer += x

print(answer)
