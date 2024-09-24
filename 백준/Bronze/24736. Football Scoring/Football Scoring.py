# 입력 받기
visiting = list(map(int, input().split()))
home = list(map(int, input().split()))

# 점수 계산
def calculate_score(T, F, S, P, C):
    return 6 * T + 3 * F + 2 * S + 1 * P + 2 * C

# 방문 팀 점수 계산
visiting_score = calculate_score(*visiting)

# 홈 팀 점수 계산
home_score = calculate_score(*home)

# 결과 출력
print(visiting_score, home_score)
