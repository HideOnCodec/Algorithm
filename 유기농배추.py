"""
백준 1012번 유기농배추
dfs를 이용하는 문제이다.

dfs를 풀 때 너무 dfs의 정형화된 공식만 생각하려고 하지 말자.
이렇게 배열이 구성되는 문제가 나오면 좌표를 생각하자.
처음부터 while문으로 스택 구현해서 dfs를 바로 돌릴 생각을 하면 안된다.
우선 배추밭 배열을 한 칸씩 돌면서 이 좌표가 방문하지 않은 곳이면 dfs에 좌표를 주고 호출한다.
dfs 함수에서 while문을 이용하여 스택에 상하좌우 값이 1이면 넣어주면서 dfs를 실행한다.
이 때 상하좌우의 조건은 배열 인덱스를 벗어나지 않고, 해당 좌표값이 1이면서, 방문하지 않은 곳이어야 스택에 들어갈 수 있다.
"""
def dfs(row,col):
    stack = []
    visited[row][col]=True
    stack.append([row,col])
    while(stack):
        node = stack.pop()
        visited[node[0]][node[1]] = True
        if node[0]!=0 and cabbage[node[0]-1][node[1]] == 1 and not visited[node[0]-1][node[1]]:
            stack.append([node[0]-1,node[1]])
        if node[0]!=N-1 and cabbage[node[0]+1][node[1]] == 1 and not visited[node[0]+1][node[1]]:
            stack.append([node[0]+1,node[1]])
        if node[1]!=0 and cabbage[node[0]][node[1]-1] == 1 and not visited[node[0]][node[1]-1]:
            stack.append([node[0],node[1]-1])
        if node[1]!=M-1 and cabbage[node[0]][node[1]+1]== 1 and not visited[node[0]-1][node[1]+1]:
            stack.append([node[0],node[1]+1])
    
T = int(input())
for i in range (T):
    M, N, K = map(int,input().split())
    visited = [[False for _ in range(M)] for _ in range(N)]
    cabbage = [[0 for _ in range(M)] for _ in range(N)]
    cnt=0
    for i in range(K):
        col,row = map(int,input().split()) # 각 배추의 행,렬 
        cabbage[row][col]=1
    for i in range(N):
        for j in range(M):
            if cabbage[i][j] == 1 and visited[i][j] == False:
                cnt+=1
                dfs(i,j)
    print(cnt)


