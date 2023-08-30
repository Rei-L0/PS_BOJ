l, r = input().split()

answer = 100
for i in range(int(l), int(r) + 1):
    answer = min(str(i).count("8"), answer)
    if answer == 0:
        break
print(answer)
