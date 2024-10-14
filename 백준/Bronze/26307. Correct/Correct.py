# 문제 해결 시간을 계산하는 함수
def calculate_total_time(HH, MM):
    # 대회 시작 시간은 9:00 AM
    start_time_in_minutes = 9 * 60  # 9시를 분으로 변환
    # 입력된 HH:MM을 분 단위로 변환
    end_time_in_minutes = HH * 60 + MM
    # 문제 해결에 소요된 총 시간을 계산
    total_time = end_time_in_minutes - start_time_in_minutes
    return total_time

# 사용자로부터 입력받기
HH, MM = map(int, input().split())

# 결과 출력
print(calculate_total_time(HH, MM))
