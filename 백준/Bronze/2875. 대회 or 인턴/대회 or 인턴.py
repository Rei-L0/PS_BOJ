N, M, K = map(int, input().split())

team = min(N//2, M//1)

chk = (N-2*team)+(M-team)

while True:
    if chk < K:
        team -= 1
        chk += 3
    else:
        print(team)
        break
