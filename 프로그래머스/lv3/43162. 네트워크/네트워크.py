def solution(n, computers):
    answer = 0
    stack=[]
    for i in range(n):
        if computers[i].count(0)!=n:
            stack.append(i)
            answer+=1
            while stack:
                x=stack.pop()
                for j in range(n):
                    if computers[x][j]==1:
                        stack.append(j)
                        computers[x][j]=0
    return answer