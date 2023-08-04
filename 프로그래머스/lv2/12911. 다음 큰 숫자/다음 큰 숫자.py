def make_bin(num):
    return bin(num)[2:]


def solution(n):
    answer = 0
    target=make_bin(n).count('1')
    for i in range(n+1,10**6+1):
        if make_bin(i).count('1')==target:
            answer=i
            break
    return answer