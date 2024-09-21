def time_to_seconds(hhmmss):
    h, m, s = map(int, hhmmss.split(':'))
    return h * 3600 + m * 60 + s

def solve():
    c, h = map(int, input().split())
    
    # 상행 열차 접근 시간
    up_trains = [time_to_seconds(input().strip()) for _ in range(c)]
    # 하행 열차 접근 시간
    down_trains = [time_to_seconds(input().strip()) for _ in range(h)]
    
    # 모든 열차 접근 시간 기록
    events = []
    
    # 상행 열차의 통과 시간 (접근한 시간부터 40초간)
    for t in up_trains:
        events.append((t, t + 40))
    
    # 하행 열차의 통과 시간 (접근한 시간부터 40초간)
    for t in down_trains:
        events.append((t, t + 40))
    
    # 시간 순서대로 정렬
    events.sort()

    # 차단기가 내려가 있는 시간 병합
    total_blocked_time = 0
    start, end = -1, -1
    
    for s, e in events:
        if s > end:
            # 현재까지의 차단기가 내려가 있던 시간 더하기
            if end != -1:
                total_blocked_time += end - start
            # 새로운 구간 시작
            start, end = s, e
        else:
            # 구간이 겹치거나 연결된 경우 구간 확장
            end = max(end, e)
    
    # 마지막 구간 추가
    if end != -1:
        total_blocked_time += end - start
    
    # 하루 총 시간(86400초) - 차단기가 내려가 있던 시간
    total_time = 86400
    print(total_time - total_blocked_time)

# 입력 예시 실행
solve()
