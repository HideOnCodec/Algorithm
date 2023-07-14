"""
백준 2342번 DanceDanceRevolution
아 진짜 스트레스받는 문제

dp를 이용해서 푸는 문제이다. 그리디를 생각하는 경우도 많은데, 그리디로 풀게되면 최소힘이 아니게 되는 경우가 생긴다.
내가 처음에 생각한 것은 RGB문제처럼 푸는 것이다. 왼발,오른발 dp를 따로 생성해서 왼발로 누를 때, 오른발로 누를 때를 나눠 이전 dp값에 더하려고했다.
이 접근방식의 문제점은 이전 발이 무엇이냐에 따라 2개씩 경우가 나눠지게 되고, 2의 n승이 되어버릴 수 있다.

결국 모든 경우를 한번에 따져서 저장하는 것이 중요하다. 모든 경우는 5*5가 된다.
5*5인 이유 : 이 부분이 잘 이해가 안갔었다. 한 발은 놔두고 다른 한 발을 내딛는다고 할 때 누를 수 있는 버튼은 5개(0,1,2,3,4).
예를 들어 왼발은 놔두고 오른발로 다음 발판을 누를 때 5 * 이제 왼발을 하나씩 옮기면서 오른발로 다음 발판을 누를 때 5

3차원 배열 dp[index][left][right]를 생성한다. index는 발판을 누르는 순서를 입력받는 order의 길이와 같다.
왼발이 0, 오른발이 1에 있을 때 (0,1)이므로 dp[index][0][1]이 된다.
모든 경우를 따지기 위해서 for문을 이용하여 각 눌러야하는 발판마다 왼발 고정일 때, 오른발 고정일 때로 나눈다.

점화식 
dp[index][left][order[i]] = min(dp[index][left][order[i]]),dp[index-1][left][right]+weight(right,order[i]) 왼발 고정 오른발 이동
dp[index][order[i]][right] = min(dp[index][order[i]][right],dp[i-1][left][right]+weight(left,order[i])) 오른발 고정 왼발 이동

마지막 최소값 출력은 최종 도착지인 dp[n-1][left][right] 값 중 가장 작은 값을 출력하면 된다.
어차피 dp배열에서 초기값 MAX를 제외한 나머지 값들은 밟아야할 발판을 밟고 온 값들이 되기 때문에(점화식에서 order[i]를 포함하므로)
dp[n-1]에 존재하는 값들은 모두 order[i]에 맞게 경로를 밟고 온 것이다.
"""
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
        for r in range(5) : # 왼발이 고정된 상태에서 오른발을 움직일 때의 모든 이전 경우를 따짐
            if l != r and l!= order[i]:
                dp[i][l][order[i]] = min(dp[i][l][order[i]],dp[i-1][l][r]+weight(r,order[i]))
    
result = MAX
for l in range(5):
    result = min(result,min(dp[n-1][l]))

print(result)
