N = int(input())

res, num = 0, 1
num1, num2 = 10, 1

while True:
    if N == 1:
        res = 1
        break
    if num2 > N:
        break
    if num2 <= N < num1:
        res += (N - num2 + 1) * num
        num2 *= 10
        num1 *= 10
    else:
        res += (num1 - num2) * num
        num += 1
        num2 *= 10
        num1 *= 10

print(res)
