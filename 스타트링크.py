"""
백준 5014번 스타트링크

BFS를 이용하여 푸는 문제.
visited 배열을 생성해서(가능한 모든 층을 크기로) 단순히 방문여부가 아닌 해당 층에 가기 위한 최소 횟수를 저장해야한다.
인접노드 그래프는 U일경우 +2, D일경우 -1한 값으로 설정한다.(물론 더하거나 뺀 값이 전체 층을 벗어나면 안된다)
1. 큐에 현재 층을 넣고 시작한다. 현재 층을 가기 위한 최소 횟수:0
2. 큐가 빌 때까지 큐 pop -> pop한 층의 인접 층들 차례대로 방문 -> 방문한 층의 기존 최소 횟수가 현재 층의 최소 횟수 + 1보다 값이 크면
방문한 층의 기존 최소 횟수를 갱신해주고 큐에 넣는다. 이를 반복한다.
-> 현재 층의 최소 횟수 + 1 의 의미는 현재 층에서 한번만 더 가면 해당 방문한 층에 도달할 수 있다는 것. 
이 값이 방문한 층의 기존 횟수보다 작으면 이 값이 최소 경로 횟수가 된다.
"""



F, S, G, U, D = map(int,input().split())
visited=[1000001 for i in range(F+1)]
graph = [[-1]]
queue = []

for i in range(1,F+1):
    nodelist=[]
    if i+U <= F: 
        nodelist.append(i+U)
    if i-D >= 1: 
        nodelist.append(i-D)
    graph.append(nodelist) # 인접 노드

queue.append(S) 
visited[S]=0 # 현재 층에서 시작, 방문 처리
success = False
while queue:

    floor=queue.pop(0)
    for i in graph[floor]:
        if visited[i]>visited[floor]+1: # 최소 횟수 갱신
            queue.append(i)
            visited[i]=visited[floor]+1 

if visited[G]==1000001:
    print('use the stairs')
else:
    print(visited[G])
            

