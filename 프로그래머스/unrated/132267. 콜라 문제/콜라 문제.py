def solution(a, b, n):
    answer = 0
    while n>=a:
        x=n//a
        n=n%a
        
        n+=x*b
        answer+=x*b
        
    return answer