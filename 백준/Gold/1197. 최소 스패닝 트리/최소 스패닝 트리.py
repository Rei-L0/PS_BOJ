import sys


def find_set(x):
    while x != parents[x]:
        x = parents[x]
    return x


v, e = map(int, sys.stdin.readline().rstrip().split())
edges = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(e)]

edges.sort(key=lambda x: x[2])
parents = [x for x in range(v + 1)]

distance, cnt = 0, 0

for a, b, value in edges:
    if find_set(a) != find_set(b):
        parents[find_set(b)] = find_set(a)
        distance += value
        cnt += 1

        if cnt >= v - 1:
            break

print(distance)
