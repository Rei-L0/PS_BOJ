def solution(clothes):
    answer = 1
    dict={key:[] for value,key in clothes}
    for v,k in clothes:
        dict[k].append(v)
    for i in dict.values():
        answer*=len(i)+1
    return answer-1