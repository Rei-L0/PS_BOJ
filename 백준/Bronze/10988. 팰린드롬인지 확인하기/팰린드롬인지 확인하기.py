def func(s):
    if len(s) % 2 == 0:
        if s[: (len(s) // 2)] == s[: (len(s) // 2) - 1 : -1]:
            return 1
        else:
            return 0
    else:
        if s[: len(s) // 2] == s[: (len(s) // 2) : -1]:
            return 1
        else:
            return 0


x = input()

print(func(x))
