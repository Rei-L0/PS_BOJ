def gcd(n1,n2):
    if n2==0: return n1
    else: return gcd(n2,n1%n2)
def lcm(n1,n2):
    return n1*n2//gcd(n1,n2)
    
def solution(arr):
    answer = 0
    x=arr[0]
    for i in range(1,len(arr)):
        x=lcm(x,arr[i])
    answer=x
    return answer