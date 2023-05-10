import math

N = int(input())

for _ in range(N):
    calander = list(map(int, input().split()))

    max_year = math.lcm(calander[1], calander[0])
    while True:
        if calander[2] > max_year or calander[3] > max_year:
            print(-1)
            break
        if calander[2] > calander[3]:
            calander[3] += calander[1]
        elif calander[2] < calander[3]:
            calander[2] += calander[0]
        else:
            print(calander[2])
            break
