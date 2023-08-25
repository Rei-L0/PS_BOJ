from collections import Counter

s = input().upper()
s_count = Counter(s).most_common()
if len(s_count) > 1:
    if s_count[0][1] == s_count[1][1]:
        print("?")
    else:
        print(s_count[0][0])
else:
    print(s_count[0][0])
