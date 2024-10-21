def sieve_of_eratosthenes(limit):
    sieve = [True] * (limit + 1)
    sieve[0] = sieve[1] = False
    for start in range(2, int(limit**0.5) + 1):
        if sieve[start]:
            for i in range(start*start, limit + 1, start):
                sieve[i] = False
    return [num for num, is_prime in enumerate(sieve) if is_prime]

def find_special_number(N):
    # 충분히 큰 범위의 소수 구하기
    primes = sieve_of_eratosthenes(100000)
    
    # 연속하는 두 소수의 곱이 N보다 큰지 확인
    for i in range(len(primes) - 1):
        special_number = primes[i] * primes[i + 1]
        if special_number > N:
            return special_number

# 입력 받기
N = int(input())

# 결과 출력
print(find_special_number(N))
