def solution(s):
    answer = []
    s=list(map(int,s.replace('{','').replace('}','').split(',')))
    s_dict={}
    for i in s:
        if i not in s_dict:
            s_dict[i]=1
        else:
            s_dict[i]+=1
    s_dict=sorted(s_dict.items(),key=lambda x: x[1],reverse=True)
    for k,v in s_dict:
        answer.append(k)
    return answer