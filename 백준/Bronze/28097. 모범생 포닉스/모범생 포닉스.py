def calculate_time(N, T):
    # 공부 시간의 총합
    total_study_time = sum(T)
    
    # 휴식 시간의 총합
    total_rest_time = (N - 1) * 8 if N > 1 else 0
    
    # 총 시간 계산
    total_time = total_study_time + total_rest_time
    
    # 총 시간을 일과 시간으로 나눔
    days = total_time // 24
    hours = total_time % 24
    
    return days, hours

# 입력 처리
N = int(input())  # 공부 계획의 수
T = list(map(int, input().split()))  # 각 공부 계획의 시간

# 결과 계산 및 출력
days, hours = calculate_time(N, T)
print(days, hours)
