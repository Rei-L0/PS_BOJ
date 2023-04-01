import math

def prime():
    n = 3000
    array = [True for i in range(n + 1)] 
    
    for i in range(2, int(math.sqrt(n)) + 1): 
        if array[i] == True: 
            j = 2 
            while i * j <= n:
                array[i * j] = False
                j += 1
    return array

def solution(nums):
    answer = 0
    chk=prime()
    
    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            for k in range(j+1,len(nums)):
                if chk[nums[i]+nums[j]+nums[k]]==True:
                    print(i+j+k)
                    answer+=1

    return answer