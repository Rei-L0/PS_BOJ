from collections import Counter

def solution(s):
    answer = []
    s=list(map(int,s.replace('{','').replace('}','').split(',')))
    s_dict=Counter(s).most_common()
    for i in s_dict:
        answer.append(i[0])
    return answer