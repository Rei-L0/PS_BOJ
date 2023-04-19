def solution(s):
    try_num, zero_num=0,0
    while len(s)!=1:
        zero_num+=s.count('0')
        try_num+=1
        s=s.replace('0','')
        x=len(s)
        s=''
        while x!=0:
            s+=str(x%2)
            x=x//2
        s=s[::-1]
    answer = [try_num,zero_num]
    return answer