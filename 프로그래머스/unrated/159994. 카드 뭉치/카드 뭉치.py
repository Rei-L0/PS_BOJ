def solution(cards1, cards2, goal):
    answer = 'Yes'
    for target in goal:
        if len(cards1) and target==cards1[0]: cards1.pop(0)
        elif len(cards2) and target==cards2[0]: cards2.pop(0)
        else: answer='No' 
    return answer