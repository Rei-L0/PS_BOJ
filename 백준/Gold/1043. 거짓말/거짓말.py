from collections import deque

n, m = map(int, input().split())

know_fact = input()

if len(know_fact) == 1:
    print(m)
else:
    people = [False] * (n + 1)
    know_fact = list(map(int, know_fact.split()))
    party = [list(map(int, input().split()))[1:] for _ in range(m)]
    queue = deque(know_fact[1:])
    ans = m

    while queue:
        x = queue.popleft()
        people[x] = True
        for party_people in party:
            if x in party_people:
                for j in party_people:
                    if not people[j]:
                        queue.append(j)

    for i in party:
        for j in i:
            if people[j]:
                ans -= 1
                break
    print(ans)
