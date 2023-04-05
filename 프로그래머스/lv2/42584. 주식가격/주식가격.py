def solution(prices):
    answer = []
    for i in range(len(prices)):
        pri=0
        for j in range(i,len(prices)-1):
            if prices[i]<=prices[j]:
                pri+=1
            else:
                break
        answer.append(pri)
    return answer