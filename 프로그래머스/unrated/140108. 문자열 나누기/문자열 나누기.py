def solution(s):
    answer = 0
    # 현재 글자 x 저장 변수
    x=s[0]
    # x가 나온 횟수 저장 변수
    x_cnt=0
    # 다른 글자가 나온 횟수
    cnt=0
    # for문으로 돌면서 x_cnt=cnt answer+=1 후 x초기화
    for i in range(len(s)):
        if x==0: x=s[i]
        if s[i]==x:
            x_cnt+=1
        else:
            cnt+=1
        if x_cnt==cnt:
            x, cnt, x_cnt=0, 0, 0
            answer+=1
    if cnt>0 or x_cnt>0:
        answer+=1
    return answer