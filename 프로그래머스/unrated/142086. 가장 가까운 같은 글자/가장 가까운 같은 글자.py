def solution(s):
    chk=dict()
    answer = []
    for i in range(len(s)):
        if s[i] not in chk:
            chk[s[i]]=i
            answer.append(-1)
        else: 
            answer.append(i-chk[s[i]])
            chk[s[i]]=i
    return answer