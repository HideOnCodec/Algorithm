"""
백준 2631번 줄세우기
dp를 이용해보자.

dp를 이용한다면 떠오르는 것은 '수열'일 것이다.
이 문제는 가장 긴 증가하는 부분 수열을 구해서 전체 N값에서 빼주면된다.
예를 들어 예제의 3,7,5,2,6,1,4에서는 부분 수열이 3,5,6이 될 것이다.
이 수열을 기준으로, 해당 수열은 굳이 움직일 필요가 없기 때문에(이미 순서대로 나열되어있음) 나머지 숫자들을 옮겨주면 된다.

가장 긴 증가하는 부분 수열을 dp로 구현하는 방법은 백준 11053번을 풀어 볼 것을 권장한다.

간략하게 설명하면 n번째까지의 긴 부분 수열을 구한다고 가정하자.
현재 모든 dp 초기값은 당연히 1일것이다.(나를 포함하면 최소 길이는 1이므로)
따라서 dp[n]도 초기는 1이다.
이제 숫자가 담긴 arr[0]~arr[n-1]까지(i라 칭한다)를 각각 arr[n]과 비교한다. 
arr[n]이 arr[i]보다 크다면 arr[n]을 수열에 추가할 수 있으므로 dp[i]+1값을 dp[n]에 넣어준다.(dp[n]=max(dp[n],seq(i)+1))
본인은 dp 함수를 재귀를 이용하여 구현했다.
"""
import sys
input = sys.stdin.readline

def seq(n):
    if dp[n] != -1:
        return dp[n]
    else:
        dp[n]=1
        for i in range(n): # 0 ~ n-1
            if arr[n] > arr[i]:
                dp[n] = max(dp[n],seq(i)+1)
        return dp[n]
     
N = int(input())
arr=[]
for i in range(N):
    arr.append(int(input()))

dp=[-1 for i in range(N)]

dp[0] = 1

for i in range(N):
    seq(i)

result = max(dp) # 가장 긴 증가하는 부분 수열 길이

print(N-result)
