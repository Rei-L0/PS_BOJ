s = input()
stack = []

for i in s:
    stack.append(i)
    if len(stack) >= 4 and stack[-1] == "P" and stack[-2] == "A":
        if stack[-3] == "P" and stack[-4] == "P":
            for i in range(4):
                stack.pop()
            stack.append("P")

if len(stack) == 1 and stack[0] == "P":
    print("PPAP")
else:
    print("NP")
