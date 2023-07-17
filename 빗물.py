"""
백준 14719번 빗물

2차원 세계 rain 배열에 블록을 표시한다.
마지막 행부터 차례대로 위로 올라가면서 밑바닥부터 빗물이 고이는지를 fill()을 호출하여 판단한다.
flag는 벽을 한번이라도 만나면 True가 된다. 일단 벽을 한번이라도 마주쳐야 빗물이 고이든 말든 하기 때문이다.
flag가 True가 된 상태일 때, 배열이 빈칸이면 빗물이 고일 수 있으므로 cnt값을 늘린다.
이 때 벽을 만나게 되면(True인 상태에서) 빗물이 고이는 것이 일단 끝나므로 sum에 cnt값을 더해주고 cnt는 0으로 초기화한다.
이렇게 하는 이유는 벽이 여러개일 경우 벽 사이마다 빗물이 고일 수 있기 때문에 cnt를 벽을 만날 때마다 초기화해주고
이전 값은 sum에 저장하는 것이다.

나의 실수
1. 무조건 두 개의 벽사이에 빗물이 고여야하기 때문에 벽을 두 쌍씩 짝지어서 그 안의 빗물을 세었다. 이렇게 했을 때 문제점은 예제 2번 그림처럼
여러 개의 벽이 홀수개로 이어 붙여져 있을 때 빗물이 고일 수도 있는데 무조건 두 쌍으로 짝지었기 때문에 빗물을 세지 않게 된다..
2. 밑바닥이 0이면 빗물이 고이지 않았기 때문에 위의 층도 자연스레 고이지 않을 것이라 생각하여 fill 호출을 하지 않았다. 
하지만 예제 1번 그림처럼 밑바닥 전체가 블록으로 채워져 있을 때 빗물의 양은 0이지만 위의 층은 빗물이 고일 수 있다. 
그냥 매 층마다 고일 수 있는 개수를 따로 세도 어차피 블록은 밑바닥부터 차례대로 쌓이는 것이고 끊겨서 쌓이지 않기 때문에 
해당 층이 고일 수 있다면 자연스레 밑의 층은 당연히 고일 수 있다.
"""
def fill(row):
    cnt=0
    sum=0
    flag=False
    for i in range(W):
        if arr[row][i] == 1 and flag==False: # 벽을 만나면
            flag=True
        elif arr[row][i] == 1 and flag==True:
            sum+=cnt
            cnt=0
        elif arr[row][i] == 0 and flag == True:
            cnt+=1
        
    return sum
          
H, W = map(int,input().split())
rain = list(map(int,input().split()))
arr = [[0 for _ in range(W)] for _ in range(H)]

# 2차원 배열에 블록 표시
for i in range(len(rain)): 
    for j in range(rain[i]):  
        arr[H-1-j][i] = 1

sum = 0
# 빗물이 고이는지 판단하기
for i in range(H):
    result=fill(H-1-i)
    sum+=result

print(sum)
