def solution(food):
    answer = []
    for i in range(1,len(food)+1):
        for j in range(food[i-1]//2):
            answer.append(str(i-1))
    answer2=''.join(answer[::-1])
    answer=''.join(answer)
    answer=answer+'0'+answer2
    return answer