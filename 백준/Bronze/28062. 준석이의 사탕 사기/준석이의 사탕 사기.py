def max_even_candy(N, candies):
    total = sum(candies)
    
    # 총합이 짝수일 경우
    if total % 2 == 0:
        return total
    
    # 홀수일 경우, 가장 작은 홀수 사탕 묶음을 빼야 함
    odd_candies = [candy for candy in candies if candy % 2 == 1]
    
    if odd_candies:
        return total - min(odd_candies)
    else:
        return 0

# 입력 받기
N = int(input())
candies = list(map(int, input().split()))

# 결과 출력
print(max_even_candy(N, candies))
