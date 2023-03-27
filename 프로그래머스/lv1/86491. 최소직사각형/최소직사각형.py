def solution(sizes):
    answer = 0
    max0=0
    max1=0
    for i in sizes:
        if i[0]<i[1]:
            i[0],i[1]=i[1],i[0]
        if i[0]>max0:
            max0=i[0]
        if i[1]>max1:
            max1=i[1]
    answer=max1*max0
    return answer