# 입력
n = int(input())
sequence = list(map(int, input().split()))

# 전체 이동 계산
total_movement = sum(sequence)

# 결과 출력
if total_movement > 0:
    print("Right")
elif total_movement < 0:
    print("Left")
else:
    print("Stay")
