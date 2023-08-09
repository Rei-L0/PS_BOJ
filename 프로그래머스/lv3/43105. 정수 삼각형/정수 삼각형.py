def solution(triangle):
    answer = 0
    dp=[[0]*(i+1) for i in range(len(triangle))]
    for i in range(len(triangle)):
        for j in range(len(triangle[i])):
            if i==0:
                dp[i][j]=triangle[i][j]
            else:
                if j==0 :
                    dp[i][j]=dp[i-1][j]+triangle[i][j]
                elif j==i:
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j]
                else:
                    dp[i][j]=max(dp[i-1][j]+triangle[i][j],dp[i-1][j-1]+triangle[i][j])
        answer=max(dp[i])
    return answer