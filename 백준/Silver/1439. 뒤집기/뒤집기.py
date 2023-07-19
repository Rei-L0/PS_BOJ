import copy

s = list(input())
s1 = copy.deepcopy(s)
s2 = copy.deepcopy(s)
cnt1 = cnt2 = 0

i = 0
while i < len(s):
    if s1[i] == "0":
        cnt1 += 1
        while i < len(s):
            if s1[i] == "1":
                break
            s1[i] = "1"
            i += 1
    i += 1

i = 0
while i < len(s):
    if s2[i] == "1":
        cnt2 += 1
        while i < len(s):
            if s2[i] == "0":
                break
            s2[i] = "0"
            i += 1
    i += 1
print(min(cnt1, cnt2))
