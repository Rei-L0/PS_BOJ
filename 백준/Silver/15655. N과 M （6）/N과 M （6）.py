N, M = map(int, input().split())

data = list(map(int, input().split()))
s = []
data.sort()


def NM(data):
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    for i in range(len(data)):
        if not s or data[i] > s[-1]:
            s.append(data[i])
            NM(data)
            s.pop()


NM(data)
