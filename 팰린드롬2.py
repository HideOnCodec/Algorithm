import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int,input().split()))
M = int(input())
question = [list(map(int,input().split())) for i in range(M)]

dp = [[-1 for i in range(N)] for i in range(N)]

# dp 초기값 설정
for i in range(N-1): #(1,2),(2,3)...(N-1,N)
    if num[i] == num[i+1]:
        dp[i][i+1] = 1
    else:
        dp[i][i+1] = 0
for i in range(N-2): #(1,3),(2,4)...(N-2,N)
    if num[i] == num[i+2]:
        dp[i][i+2] = 1
    else:
        dp[i][i+2] = 0
for i in range(N):
    dp[i][i]=1
for i in range(3,N):
    for j in range(N-i):
        if dp[j+1][j+i-1] == 0:
            dp[j][j+i]=0
        else:
            if num[j] == num[j+i]:
                dp[j][j+i]=1
            else:
                dp[j][j+i]=0

for i in range(M): # 질문
    start = question[i][0]-1
    end = question[i][1]-1
    print(dp[start][end])
