def solution(progresses, speeds):
    answer = []
    while True:
        for i in range(len(speeds)):
            progresses[i]+=speeds[i]
        if progresses[0]>=100:
            res=0
            while progresses:
                if progresses[0]>=100:
                    progresses.pop(0)
                    speeds.pop(0)
                    res+=1
                else:
                    break
            answer.append(res)
        if not speeds:
            break
    return answer

