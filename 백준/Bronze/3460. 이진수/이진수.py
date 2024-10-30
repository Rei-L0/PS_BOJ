T = int(input())  # 테스트 케이스 개수 입력

for _ in range(T):
    n = int(input())  # 각 테스트 케이스의 양의 정수 n 입력
    positions = []  # '1'의 위치를 저장할 리스트
    bit_position = 0  # 현재 비트 위치
    
    # n이 0이 될 때까지 비트를 오른쪽으로 이동하며 '1' 위치를 체크
    while n > 0:
        if n & 1:  # n의 최하위 비트가 '1'인지 확인
            positions.append(bit_position)
        n >>= 1  # n을 오른쪽으로 1비트 이동
        bit_position += 1
    
    # 위치 정보 출력 (공백으로 구분)
    print(" ".join(map(str, positions)))
