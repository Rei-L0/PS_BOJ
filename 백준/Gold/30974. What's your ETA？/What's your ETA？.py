import heapq,sys

prime=[True]*(10**7+1)
INF=400000**2
for i in range(2,len(prime)):
    if prime[i]:
        for j in range(i+i,len(prime),i):
            prime[j]=False

n,m=map(int,sys.stdin.readline().rstrip().split())

disaster_code=[0]+list(map(int,sys.stdin.readline().rstrip().split()))

graph=[[] for _ in range(n+1)]

for _ in range(m):
    s,e,w=map(int,sys.stdin.readline().rstrip().split())
    graph[s].append((w,e))
    graph[e].append((w,s))
    
def solve():
    ans_dist=[INF]*(n+1)
    ans_dist[1]=0
    q=[]
    heapq.heappush(q,(0,1))
    
    while q:
        dis,start=heapq.heappop(q)
        if ans_dist[start]<dis:
            continue
        for i in graph[start]:
            if prime[disaster_code[start]+disaster_code[i[1]]]:
                if ans_dist[i[1]]>dis+i[0]:
                    ans_dist[i[1]]=dis+i[0]
                    heapq.heappush(q,(dis+i[0],i[1]))
    return ans_dist[n]

ans=solve()
if ans==INF:
    print('Now where are you?')
else:
    print(ans)
        