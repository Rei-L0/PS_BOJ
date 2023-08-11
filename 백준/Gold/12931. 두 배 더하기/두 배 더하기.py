n = int(input())
data = list(map(int, input().split()))

answer = 0

while data.count(0) != n:
    for i in range(n):
        if data[i] % 2 != 0:
            data[i] -= 1
            answer += 1
    for i in range(n):
        data[i] //= 2
    if data.count(0) != n:
        answer += 1

print(answer)
