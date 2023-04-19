def solution(s):
    stack=list()
    for i in s:
        if stack:
            if i==stack[-1]:
                stack.pop()
            else:
                stack.append(i)
        else:
            stack.append(i)
    if stack:
        return 0
    else:
        return 1 