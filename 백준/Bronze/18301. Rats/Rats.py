import math

def estimate_rats(n1, n2, n12):
    # Chapman 추정식을 사용한 총 쥐의 수 계산
    N = math.floor((n1 + 1) * (n2 + 1) / (n12 + 1) - 1)
    return N

# 입력 받기
n1, n2, n12 = map(int, input().split())

# 결과 출력
print(estimate_rats(n1, n2, n12))
