# 입력 받기
N = int(input())  # 문자열의 길이
S = input().strip()  # 문자열

# 모음 리스트
vowels = {'a', 'i', 'u', 'e', 'o'}

# 모음 개수 세기
vowel_count = sum(1 for char in S if char in vowels)

# 결과 출력
print(vowel_count)
