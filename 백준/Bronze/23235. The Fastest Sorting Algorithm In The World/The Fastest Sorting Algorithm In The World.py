case_number = 1

while True:
    # 입력 받기
    data = list(map(int, input().split()))
    
    # N이 0이면 종료
    if data[0] == 0:
        break
    
    # 출력 형식에 맞게 출력
    print(f"Case {case_number}: Sorting... done!")
    case_number += 1
