def solution(brown, yellow):
    answer = []
    avail=[]
    for i in range(3,(brown+yellow)//2):
        if (brown+yellow)%i==0:
            avail.append((((brown+yellow)//i),i))
    for i in avail:
        if (i[0]-2)*(i[1]-2)==yellow:
            answer.append(i[0])
            answer.append(i[1])
            break
    return answer