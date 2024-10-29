# 입력을 받아서 정수로 변환합니다.
UR, TR, UO, TO = map(int, input().split())

# 사이트 점수를 계산합니다.
site_score = 56 * UR + 24 * TR + 14 * UO + 6 * TO

# 결과를 출력합니다.
print(site_score)
