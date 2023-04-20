def solution(s):
    answer = 0
    for i in range(len(s)):
        stack=list()
        s=s[1:]+s[0]
        x=list(reversed(list(s)))
        while True:
            y=x.pop()
            if not stack:
                stack.append(y)
            else:
                if y==']' and stack[-1]=='[':
                    stack.pop()
                elif y=='}' and stack[-1]=='{':
                    stack.pop()
                elif y==')' and stack[-1]=='(':
                    stack.pop()
                else:
                    stack.append(y)
            if not x:
                break
        if not stack:
            answer+=1
    return answer