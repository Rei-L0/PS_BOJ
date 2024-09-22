# 입력 받기
father_body, father_tail = input().split()
mother_body, mother_tail = input().split()

# 가능한 몸통 색과 꼬리 색의 모든 조합을 set에 저장하여 중복 제거
body_colors = {father_body, father_tail, mother_body, mother_tail}
tail_colors = {father_body, father_tail, mother_body, mother_tail}

# 모든 조합을 만들고 중복을 제거한 후 사전 순으로 정렬
combinations = sorted([(body, tail) for body in body_colors for tail in tail_colors])

# 출력
for body, tail in combinations:
    print(body, tail)
