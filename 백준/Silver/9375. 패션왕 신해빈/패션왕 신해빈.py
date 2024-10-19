def solution():
    t = int(input())  # 테스트 케이스의 수
    for _ in range(t):
        n = int(input())  # 의상의 수
        clothes = {}
        
        for _ in range(n):
            item, kind = input().split()
            if kind in clothes:
                clothes[kind] += 1
            else:
                clothes[kind] = 1
                
        result = 1
        for count in clothes.values():
            result *= (count + 1)  # 해당 종류의 의상 선택 경우의 수
        
        print(result - 1)  # 아무것도 입지 않은 경우를 제외

# 예제 실행
solution()
