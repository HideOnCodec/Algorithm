"""
백준 1012번 유기농배추
dfs를 이용하는 문제이다.
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
