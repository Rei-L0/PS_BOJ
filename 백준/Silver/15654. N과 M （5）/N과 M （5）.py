N, M = map(int, input().split())

data = list(map(int, input().split()))
s = []
data.sort()


def NM(data):
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    for i in range(len(data)):
        if data[i] not in s:
            s.append(data[i])
            NM(data)
            s.pop()


NM(data)
