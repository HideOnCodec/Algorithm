"""
백준 10552번 DOM
영어로 나와서 당황;; DFS를 이용하는 문제이다.

stack에 처음 채널을 넣어준다. stack이 비어있을 때까지 while문을 반복하며 DFS를 돈다.
stack에 들어간 채널은 즉 현재 틀어지고 있는 채널이 된다.
현재 채널을 싫어하는 노인들 중 가장 어린 사람을 hateList에서 구한다.(min(hateList[channel]))

막내가 좋아하는 채널로 바꿔야하는데, 좋아하는 채널이 이미 방문한 채널이면 무한반복이 되므로 -1을 출력하고 exit()한다.
만약 방문하지 않은 채널이면, 방문을 True로 바꿔주고 stack에 현재 채널로써 넣어준다.
그리고 change count를 1 늘려준다. 
"""

N, M, P = map(int,input().split())
hateList = [[] for _ in range(M+1)] # 각 채널별 싫어하는 노인 리스트
favoriteList = {} # 각 노인별 좋아하는 채널
visited=[False for _ in range(M+1)]
for i in range(1,N+1):
    f, h = map(int,input().split()) # favourite hate
    favoriteList[i]=f
    hateList[h].append(i)

stack = []
stack.append(P)
visited[P] = True
cnt=0
while(stack):
    channel = stack.pop()
    if len(hateList[channel])>0:
        young=min(hateList[channel])
        favorite = favoriteList[young]
        if visited[favorite]:
            print(-1)
            exit()
        else:
            visited[favorite]=True
            stack.append(favorite)
            cnt+=1

print(cnt)
