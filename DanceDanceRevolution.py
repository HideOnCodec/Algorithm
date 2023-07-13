def weight(prev,next):
    if (prev == 1 and next == 3) or (prev == 3 and next == 1) or (prev == 2 and next == 4) or (prev == 4 and next ==2):
        return 4
    elif (prev == next):
        return 1
    elif prev == 0:
        return 2
    else:
        return 3
    
order = list(map(int,input().split()))
del order[len(order)-1]
n = len(order)

MAX = 500000 
# dp 3차원 배열 -> dp[index][left][right] index는 0번째,1번째...n번째
dp = [[[MAX for i in range(5)] for i in range(5)] for i in range(n) ] 
dp[0][order[0]][0] = 2
dp[0][0][order[0]] = 2

for i in range(1,n):
    # 모든 경우의 수는 25(5*5)
    # 가야될 번호(order[i])로 왼발을 움직여서 갈 때의 모든 경우의수
    for r in range(5):
        for l in range(5) : # 오른발이 고정된 상태에서 왼발을 움직일 때의 모든 이전 경우를 따짐
            if r!= l and r!=order[i]:
                dp[i][order[i]][r] = min(dp[i][order[i]][r],dp[i-1][l][r]+weight(l,order[i])) 
    # 가야될 번호(order[i])로 오른발을 움직여서 갈 때의 모든 경우의수
    for l in range(5):
        for r in range(5) : # 오른발이 고정된 상태에서 왼발을 움직일 때의 모든 이전 경우를 따짐
            if l != r and l!= order[i]:
                dp[i][l][order[i]] = min(dp[i][l][order[i]],dp[i-1][l][r]+weight(r,order[i]))
    
result = MAX
for l in range(5):
    result = min(result,min(dp[n-1][l]))

print(result)
