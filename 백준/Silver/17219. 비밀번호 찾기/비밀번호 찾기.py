import sys

input = sys.stdin.readline

n, m = map(int, input().split())
site = dict()

for _ in range(n):
    x, y = input().rstrip().split()
    site[x] = y

for _ in range(m):
    address = input().rstrip()
    print(site[address])
