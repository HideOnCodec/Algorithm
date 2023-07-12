"""
백준 10942번 팰린드롬?
시간제한이 0.5초이므로 단순히 문자끼리 비교해서 푸는 방식은 시간초과가 발생한다. dp를 이용하자.

dp는 작은 것을 이용하여 점점 큰 문제를 해결하는 방식이다. 즉 이전 dp값을 현재 문제를 푸는데 이용해야한다.
예를 들어 질문이 1,6이라 하자.
1,2,3,4,5,6 에서 1~6까지를 일일히 비교할 필요없이 2,5 혹은 3,4가 팰린드롬인지 여부만 알면 짧은 시간에 해결할 수 있다.

즉 dp 2차원 배열을 -1로 초기화하여 생성하고, 질문에 해당하는 인덱스(i,j)에 팰린드롬 여부를 미리 저장해둔다.
초기값 (1,2),(2,3)...(N-1,N)까지를 구해서 저장하고, 그 다음 (1,2,3),(2,3,4)...(N-2,N)을 구해서 저장해둔다.
이 다음부터는 일일히 비교할 필요 없이 (s,e)인 경우 (s+1,e-1)값이 1이면 팰린드롬이므로 num[s]와 num[e]를 비교해서 같으면 1, 아니면 0이된다.
쉽게 예를 들면 (1,6)을 구하는 경우, (2,5)의 팰린드롬 여부를 알면 num[1]과 num[6]만 비교하면 된다.
(2,5)의 팰린드롬 여부는 마찬가지로 (3,4)의 팰린드롬 여부를 통해 알 수 있고 이는 이미 dp배열 초기값에 설정되어있다.

*중요점*
시간 초과가 중요한 문제이므로 import sys를 통해 input = sys.stdin.readline을 꼭 넣어주자..안그러면 답이 맞아도 시간초과가 난다.
내가 실수했던 건 단순히 (1,6)의 팰린드롬 여부를 판단할 때 (2,5)가 팰린드롬인지 아닌지만 판단하고 끝낸 것이다.
당연히 안의 숫자들이 팰린드롬이어도 가장 바깥쪽 숫자까지 팰린드롬이어야 팰린드롬이 완성되므로 꼭 num[1],num[6]도 판단을 해줘야한다.
"""
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
