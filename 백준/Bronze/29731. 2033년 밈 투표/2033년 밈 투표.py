# Rick Astley의 공약 리스트 정의
original_pledges = [
    "Never gonna give you up",
    "Never gonna let you down",
    "Never gonna run around and desert you",
    "Never gonna make you cry",
    "Never gonna say goodbye",
    "Never gonna tell a lie and hurt you",
    "Never gonna stop"
]

# 입력 받기
N = int(input())
pledges = [input().strip() for _ in range(N)]

# 모든 문장이 공약에 포함되는지 확인
changed = any(pledge not in original_pledges for pledge in pledges)

# 결과 출력
if changed:
    print("Yes")
else:
    print("No")
