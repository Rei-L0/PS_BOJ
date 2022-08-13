A, B, C, X, Y = map(int, input().split())

if X > Y:
    print(min(A*X+B*Y, C*Y*2+(X-Y)*A, C*2*X))
else:
    print(min(A*X+B*Y, C*X*2+(Y-X)*B, C*2*Y))
