def solution(x, n):
    answer = []
    a=x
    while len(answer)!=n:
        answer.append(x)
        x+=a
    return answer