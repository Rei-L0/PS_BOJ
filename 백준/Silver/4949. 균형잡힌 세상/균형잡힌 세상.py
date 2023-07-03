while True:
    s = input()
    if s == ".":
        break
    stack = list()
    chk = "yes"
    for i in s:
        if i == "(" or i == "[":
            stack.append(i)
        if i == ")":
            if stack:
                if stack[-1] == "(":
                    stack.pop()
                else:
                    chk = "no"
                    break
            else:
                chk = "no"
                break
        if i == "]":
            if stack:
                if stack[-1] == "[":
                    stack.pop()
                else:
                    chk = "no"
                    break
            else:
                chk = "no"
                break
    if stack:
        chk = "no"
    print(chk)
