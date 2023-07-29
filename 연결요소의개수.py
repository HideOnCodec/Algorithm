"""
백준 11724번 연결 요소의 개수
DFS를 이용하는 문제이다.

전공 때 배운 그래프를 생각해보자.
첫번 째 예제를 보면 1 2, 2 5, 5 1은 서로 연결되어 사이클이 형성되며 연결 요소가 된다.

각 정점마다 인접 리스트를 가진다. 예) 1번: 2,5 2번: 1, 5 ...
그리고 정점마다 방문여부를 따지는 visited 배열을 만든다.
for문으로 각 정점을 차례대로 DFS에 넣어 돌려본다. 이 때 이미 방문한 노드이면 DFS에 넣지 않고 continue한다.
"""
N, M = map(int,input().split())
graph = [[] for _ in range(N+1)] # 0번 리스트는 사용하지 않음
visited=[False for _ in range(N+1)] # 0번 사용하지 않음
for i in range(M):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0
stack = []

for i in range(1,N+1):
    if visited[i] == True:
        continue
    else:
        stack.append(i)
        cnt+=1
        while(stack):
            node = stack.pop()

            for j in graph[node]:
                if visited[j]==False:
                    visited[j]=True
                    stack.append(j)
            
print(cnt)
