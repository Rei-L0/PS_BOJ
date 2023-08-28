import sys
input = sys.stdin.readline

def op1(arr):
    # 원본 배열을 A , 연산 후 배열을 B 라고 했을 때
    # B[i][j] = A[N-i-1][j]
    n = len(a)
    m = len(a[0])
    ans = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            ans[i][j] = arr[n-i-1][j]
    return ans

def op2(arr):
    # 원본 배열을 A , 연산 후 배열을 B 라고 했을 때
    # B[i][j] = A[i][M-j-1]
    n = len(a)
    m = len(a[0])
    ans = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            ans[i][j] = arr[i][m-j-1]
    return ans


def op3(arr):
    # 원본 배열을 A , 연산 후 배열을 B 라고 했을 때
    # B[i][j] = A[N-j-1][i]
    n = len(a)
    m = len(a[0])
    ans = [[0]*n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            ans[i][j] = arr[n-j-1][i]
    return ans


def op4(arr):
    # 원본 배열을 A , 연산 후 배열을 B 라고 했을 때
    # B[i][j] = A[j][M-i-1]
    n = len(a)
    m = len(a[0])
    ans = [[0]*n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            ans[i][j] = arr[j][m-i-1]
    return ans


def op5(arr):
    n = len(a)
    m = len(a[0])
    ans = [[0]*m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            ans[i][j+m//2] = a[i][j]
            ans[i+n//2][j+m//2] = a[i][j+m//2]
            ans[i+n//2][j] = a[i+n//2][j+m//2]
            ans[i][j] = a[i+n//2][j]
    return ans


def op6(arr):
    n = len(a)
    m = len(a[0])
    ans = [[0]*m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            ans[i+n//2][j] = a[i][j]
            ans[i][j] = a[i][j+m//2]
            ans[i][j+m//2] = a[i+n//2][j+m//2]
            ans[i+n//2][j+m//2] = a[i+n//2][j]
    return ans

n,m,r = map(int,input().rstrip().split())
a = [list(map(int,input().rstrip().split())) for _ in range(n)]
func = [op1,op2,op3,op4,op5,op6]
for op in map(int,input().rstrip().split()):
    a = func[op-1](a)
for row in a:
    print(*row,sep=' ')