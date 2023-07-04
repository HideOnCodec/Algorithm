"""
백준 9252번 LCS2
LCS 문제는 다이나믹 프로그래밍을 이용한다.
두 개의 문자열을 입력받았을 때, 하나는 행 다른 하나는 열로 2차원 배열 dp[][]을 생성한다.
각 문자끼리 비교해서 같으면 dp[i][j]=dp[i-1][j-1] + 1, 다르면 max(dp[i-1][j],dp[i][j-1])값을 저장한다.
이 과정을 반복하면 마지막 dp[max][max]에는 최대 부분 수열의 길이가 저장된다.

LCS2는 LCS와 달리 최대 부분 수열을 출력하라고 한다.
이 문자열을 찾기 위해서는 위의 과정을 거꾸로 인덱스를 따라가면된다.
반복문 혹은 재귀문을 이용하여 dp[max][max]부터 각 문자가 같으면 해당 문자를 저장하고 dp[i-1][j-1]로 이동한다.
각 문자가 다르면 dp[i-1][j], dp[i][j-1] 중 큰 값으로 따라간다.
이 과정은 i,j가 모두 0보다 클 때까지 반복한다.(중요) 이 조건문을 제대로 설정하지 않으면 반복 에러가 발생한다.
"""


result = []
def LCS(col,row):
    dp = [[0]*(len(col)+1) for i in range(len(row)+1)]
    for i in range(1,len(row)+1):
        for j in range(1,len(col)+1):
            if col[j-1] == row[i-1]:
                dp[i][j]=dp[i-1][j-1]+1
            else :
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                
    print(max(dp[len(row)]))
    if max(dp[len(row)]) == 0:
        return
    i = len(row)
    j = len(col)
    while i>0 and j>0:
        if row[i-1] == col[j-1]:
            result.append(row[i-1])
            i = i-1
            j = j-1
        else:
            if dp[i-1][j] == dp[i][j]:
                i = i-1
            else:
                j = j-1

    for c in reversed(result):
        print(c,end='')

col = input()
row = input()
LCS(col,row)
