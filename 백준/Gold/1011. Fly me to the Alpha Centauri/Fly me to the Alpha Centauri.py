tc = int(input())

for _ in range(tc):
    s, e = map(int, input().split())
    distance = e - s
    count = 0  
    move = 1  
    move_plus = 0  
    while move_plus < distance:
        count += 1
        move_plus += move  
        if count % 2 == 0:  
            move += 1
    print(count)
