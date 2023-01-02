def func(depth):
    if len(result) == 6:
        count = 0
        for i in range(1, 6):
            if result[i-1] < result[i]:
                count += 1
        if count == 5:
            print(' '.join(map(str, result)))
            return
    for i in range(depth, data[0]+1):
        if data[i] not in result:
            result.append(data[i])
            func(depth+1)
            result.pop()


while True:
    data = list(map(int, input().split()))

    result = []

    if data[0] == 0:
        break
    else:
        func(1)
        print('')
