# 시험 본 과목의 개수 입력
N = int(input())

# 현재 성적 입력
scores = list(map(int, input().split()))

# 최댓값 찾기
M = max(scores)

# 점수를 변환하고 새로운 평균 구하기
new_scores = [(score / M) * 100 for score in scores]
average = sum(new_scores) / N

# 결과 출력
print(f"{average:.6f}")
