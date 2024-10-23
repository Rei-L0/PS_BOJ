def haligali(N, cards):
    # 과일 별 개수를 저장할 딕셔너리 초기화
    fruit_counts = {
        "STRAWBERRY": 0,
        "BANANA": 0,
        "LIME": 0,
        "PLUM": 0
    }
    
    # 주어진 카드들을 하나씩 처리
    for card in cards:
        fruit, count = card.split()
        count = int(count)
        fruit_counts[fruit] += count
    
    # 어떤 과일이라도 개수가 정확히 5개인지 확인
    for count in fruit_counts.values():
        if count == 5:
            return "YES"
    
    return "NO"

# 입력 받기
N = int(input())
cards = [input() for _ in range(N)]

# 결과 출력
print(haligali(N, cards))
