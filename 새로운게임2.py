"""
백준 17837번 새로운게임2
시뮬레이션 문제는 예외상항을 모두 고려해야해서 시간이 오래걸린다. 특히 조건문은 하나하나 생각해보면서 짜야한다.

보드 배열(board), 말들 정보(pieces), 보드판 색깔(boardColor) 생성한다.
보드 위의 말들을 놓을 때 string으로 구현했다.(큐 구현도 가능)

turn마다 말들을 하나씩 이동시킨다. i번 말이 이동할 때 본인 위치의 String에서 몇 번째로 쌓여있는지를 구한다.(find함수 이용)
규칙에 따르면 본인부터 위에 쌓인 말들은 같이 이동한다. 현재 위치에서 다음 위치로 이동하는 말들(move), 이동하지않고 남아있는 말들(rest)로 나눈다.
그리고 방향에 따라 나아갈 보드판 위치를 구한다.(position():newrow,newcol) 
그리고 구한 위치의 보드판 색깔을 따져서 이동하면 된다.(color=boardColor[newrow][newcol])

중요점 1.
구한 다음 위치가 벽 넘어일 경우, color 변수에 바로 2(파란색)을 넣어준다.(규칙에 따르면 벽은 파란색과 같다)
boardColor[newrow][newcol]로 다음 칸의 색깔을 구하면 인덱스 에러난다.  
중요점 2.
파란색 구현에서 예외상황을 잘 따져야하고 여기서 에러가 많이 생겼다.(너무 힘들었다..)
우선 다음 칸이 파란색인 경우 i번째 말의 방향을 바꿔준다. 그리고 해당 방향으로 한 칸 이동했을 때의 위치를 다시 구한다.(position())
이 때 나는 실수로 해당 칸의 color를 깜빡하고 다시 갱신해주지 않아서 헤맸다.
꼭 다음 칸의 위치를 구할 때마다 color 값을 갱신하는 것을 잊지 말자.(즉 newrow,newcol을 새로 구할 때마다 color값도 구해서 넣어주자..)

그리고 방향을 바꾸고 다음 칸으로 갔을 때 벽인 경우 또는 파란색인 경우도 고려한다.(제발) 이 경우에는 아무것도 하지않고 continue로 넘어간다.
다음 칸이 흰색인 경우, 빨간색인 경우는 그대로 똑같이 수행해주면 된다.
중요점 3.
내가 실수했던 건 턴을 한 번 돌고나서의 결과로 4개가 쌓여있는지를 판단했다.(isContinue())
근데 한 턴이 다 돌기 전에 그 과정에서 4개가 쌓였다가 턴이 끝날 때는 다시 흩어질 수 있다. 따라서 4개가 쌓인 그 즉시 종료시켜야한다.
즉 매번 말을 하나씩 옮길때마다 isContinue()를 호출하여 판단해야한다.

중요점 4.
제일 어이없던 실수는 4개가 쌓여야한다고 생각하고 len(string)==4라는 조건문을 걸었다.
생각해보니 말이 5개 이상일 때 한번에 여러 개의 말들이 같이 움직여서 5개 이상의 말들이 쌓여있을 수도 있다.
따라서 len(string)>=4 로 걸어야한다.(이것 때문에 예제 다 맞고도 틀렸다...)

조건문은 항상 꼼꼼히 생각하고, 예외상황을 잘 정리해서 고려해야한다. 
특히 시뮬레이션 구현은 인덱스 에러가 많이 발생하기 때문에 처음부터 행,열,인덱스를 잘 통일시켜서 구현하자.
제일 좋은 방법은 그림을 직접 그려보면서 수기로 대략적인 알고리즘을 정리해보는 게 좋은 거 같다.
새로운게임2..힘들었고 다신 보지 말자..
"""


direction = {1:2, 2:1, 3:4, 4:3}

def movePieces(string,newrow,newcol):
    for c in string:
        pieces[int(c)][0],pieces[int(c)][1]=newrow,newcol

def position(d,newrow,newcol,row,col):
    if d == 1:
        newcol=col+1
    elif d == 2:
        newcol=col-1
    elif d == 3:
        newrow=row-1
    elif d == 4:
        newrow=row+1
    return newrow,newcol

def turn(count):
    for i in range(K): # 1번~K번 말까지 차례대로 이동
        row = pieces[i][0]
        col = pieces[i][1]
        d=pieces[i][2]
        # 앞으로 갈 위치     
        newrow = row
        newcol = col 

        move='' # 이동할 말들
        rest='' # 남아있는 말들

        index=board[row][col].find(str(i)) # 해당 말이 바닥에서부터 몇 번째 위에 있는지
        if index == 0:
            move = board[row][col]
        else:
            move= board[row][col][index:len(board[row][col])]
            rest = board[row][col][0:index]

        newrow,newcol=position(d,newrow,newcol,row,col)
        # 벽을 만나면 파란색으로 취급
        if newcol>=N or newcol<=-1 or newrow>=N or newrow<=-1:
            color=2
        else:
            color = boardColor[newrow][newcol] # 앞으로 갈 위치의 색깔
        
        if color == 0:
            board[row][col]=rest
            board[newrow][newcol] += move
            movePieces(move,newrow,newcol)
        elif color == 1:
            board[row][col] = rest
            
            p = "".join(reversed(move)) 
            board[newrow][newcol]+=p
            movePieces(move,newrow,newcol)
        elif color == 2:
            pieces[i][2]=direction[d] # 방향 바꾸기
            newrow,newcol=position(pieces[i][2],newrow,newcol,row,col)
            # 벽을 만나면 파란색으로 취급
            if newcol>=N or newcol<=-1 or newrow>=N or newrow<=-1 or boardColor[newrow][newcol] == 2: 
                continue   
            color = boardColor[newrow][newcol]
            if color == 0:
                board[row][col]=rest
                board[newrow][newcol] += move
                movePieces(move,newrow,newcol)
            elif color == 1:
                board[row][col] = rest
                
                p = "".join(reversed(move)) 
                board[newrow][newcol]+=p
                movePieces(move,newrow,newcol)
        if isContinue(board) == False:
            print(count+1)
            exit()

    return count+1

def isContinue(board):
    for i in range(N):
        for j in range(N):
            if len(board[i][j]) >= 4:
                return False
    return True

N,K = map(int, input().split())
boardColor = []
list1=[]
board = [['']*N for i in range(N)]
pieces = []                                                                 
count=0
for i in range(N):
    boardColor.append(list(map(int,input().split())))

# 방향 : 1(우) 2(좌) 3(상) 4(하)    
for i in range(K):
    pieces.append(list(map(int,input().split()))) # 행, 열, 방향
    pieces[i][0]-=1
    pieces[i][1]-=1
    board[pieces[i][0]][pieces[i][1]]=str(i) # 인덱스 0부터 시작, 행 열 값 각각 -1 필요!

count=0
# 흰색(0) , 빨강(1), 파랑(2)
while True:
    count=turn(count)
    if count >= 1000:
        print(-1)
        break
