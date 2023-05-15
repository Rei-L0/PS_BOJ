while True:
    try:
        N = int(input())
        num = "1"
        cnt = 1
        while True:
            if int(num) % N == 0:
                print(cnt)
                break
            num += "1"
            cnt += 1
    except:
        break
