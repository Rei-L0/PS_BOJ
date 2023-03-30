from collections import Counter

def solution(participant, completion):
    par=Counter(participant)
    com=Counter(completion)
    
    for i in par:
        if par[i]!=com[i]:
            answer=i
    return answer