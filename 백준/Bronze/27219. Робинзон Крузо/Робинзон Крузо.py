n = int(input())

v_count = n // 5  # "V"의 개수
i_count = n % 5   # "I"의 개수

result = 'V' * v_count + 'I' * i_count
print(result)
