def solution(wallpaper):
    answer=[50,50,-1,-1]
    for i in range(len(wallpaper)):
        wallpaper[i]=list(wallpaper[i])
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j]=='#':
                answer=[min(answer[0],i),min(answer[1],j)
                       ,max(answer[2],i+1),max(answer[3],j+1)]
    return answer