def solution(keymap, targets):
    keymap=list(map(list,keymap))
    answer = []
    for i in range(len(targets)):
        res=0
        targets=list(targets)
        for j in range(len(targets[i])):
            key_min=150
            for k in range(len(keymap)):
                if targets[i][j] in keymap[k]:
                    key_min=min(key_min,keymap[k].index(targets[i][j])+1)
            if key_min==150:
                res=-1
                break
            res+=key_min
        answer.append(res)
    return answer