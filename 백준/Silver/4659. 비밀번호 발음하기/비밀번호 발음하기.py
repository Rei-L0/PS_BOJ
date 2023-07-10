import sys


def check(s):
    mo = ["a", "e", "i", "o", "u"]
    chk = False
    for i in range(len(s)):
        if s[i] in mo:
            chk = True
    for i in range(0, len(s) - 2):
        if s[i] in mo and s[i + 1] in mo and s[i + 2] in mo:
            chk = False
        if s[i] not in mo and s[i + 1] not in mo and s[i + 2] not in mo:
            chk = False

    for i in range(0, len(s) - 1):
        if not s[i] == "o" and not s[i] == "e":
            if s[i] == s[i + 1]:
                chk = False

    if chk == True:
        print(f"<{s}> is acceptable.")
    else:
        print(f"<{s}> is not acceptable.")


while True:
    x = sys.stdin.readline().rstrip()
    if x == "end":
        break
    else:
        check(x)
