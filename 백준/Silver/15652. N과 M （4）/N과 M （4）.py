N, M = map(int, input().split())

s = []


def NM():
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    for i in range(1, N+1):
        if not s or i >= s[-1]:
            s.append(i)
            NM()
            s.pop()


NM()
