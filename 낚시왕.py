"""
백준 17143번 낚시왕
굉장히 짜증나는 문제였다.

모든 상어 정보를 담은 shark 배열, 격자판을 구현한 grid 배열을 생성.
for문으로 낚시왕을 오른쪽으로 차례대로 한 칸씩 옮긴다.

1. 땅에 가장 가까운 상어 잡기
열(col)은 고정한채로 row값을 1~R까지 검사해서 처음 걸리는 상어를 잡고 break
상어의 크기를 전역변수 sum에 저장함.
잡은 상어 정보를 삭제하기 위해 shark 배열에서 -1로 채운다. (해당 인덱스의 리스트 자체를 삭제하면 리스트 길이가 줄어들어서 이후 코드에서 에러 발생함..)

2. 상어 이동
상어 이동 전에 격자판을 모두 -1로 초기화한다.(한 칸에 두 마리 이상의 상어가 위치하는 경우를 따지기 위해서..)
차례대로 for문으로 shark 배열을 순회하며 상어를 이동시킨다.
shark 정보가 -1이 아닌 경우 
이동 방향이 1 또는 2일 때(상하이동), 3 또는 4일 때(좌우이동)로 구분
각 바라보고 있는 방향대로 우선 격자판 끝까지 이동시킴(예를 들어 방향이 1인 경우 격자판 1행까지 쭉 이동)
이 이동거리를 move에 저장.
1. 속력이 move 이하이면 방향이 바뀌지 않으므로 방향에 맞춰 속력값을 위치에 더해주거나 빼주면 됨
2. 속력이 move 이상이면 무조건 벽에 닿아 방향이 한 번 이상은 바뀐다.
여기가 정말 중요하다. 상어의 위치를 구하는 계산식을 생각해내야한다.(반복문으로 한칸씩 이동하며 상어 위치를 판단하면 시간이 너무 오래걸리므로..)
이 경우 일단 move만큼 벽까지 이동한 상태라고 생각하고 남은 거리를 계산한다.(rest = 속력 - move)
이 rest 값을 (상하 이동이면 R, 좌우이동이면 C)-1로 나눈 몫이 짝수인지 홀수인지 판단.(짝수 : 최초 방향과 반대, 홀수 : 최초 방향과 일치)
여기서 -1을 해주는 이유는 상어가 벽에 닿는 경우 다음에 바로 한 칸 움직이기 때문이다. 벽에 닿는 경우 방향전환없이 움직일 수 있는 거리는 R or C - 1 값이다.
방향이 달라지면 shark배열의 방향값을 바꿔준다.
그리고 각각 방향이 1,2,3,4일 때마다 rest%(R or C - 1)한 값을 시작점(1)에다 더하거나 끝점(R or C)에서 빼줌으로써 위치를 구할 수 있다.
1 : R - rest%(R-1)
2 : 1 + rest%(R-1)
3 : 1 + rest%(C-1)
4 : C - rest%(C-1)
상어가 바라보고 있는 방향에서 나머지 값만큼 움직인다고 생각하면 이해하기 쉽다.

3. 같은 칸의 상어 
만약 상어를 격자판에 배치시키려는데 이미 다른 상어가 있다면 둘의 크기를 비교해서 큰 상어의 인덱스를 격자판에 넣어준다.

"""

size = []
direction = {1:2, 2:1, 3:4, 4:3}
def fishing(grid,shark):
    sum=0
    for col in range(1,C+1): # 낚시왕의 x축 위치
        for i in range(1,R+1): # 땅에 가장 가까운 상어 잡기
            index = grid[i][col]
            if index != -1:
                sum+=shark[index][4]
                shark[index]=[-1,-1,-1,-1,-1] # 상어 삭제
                grid[i][col] = -1
                break
        # 상어 이동 전에 격자판 -1로 초기화
        for i in range(1,R+1):
            for j in range(1,C+1):
                grid[i][j]=-1
        # 상어 이동
        for i in range(len(shark)):
            if shark[i][0]!=-1:
                if shark[i][3] == 1 or shark[i][3] == 2: # 상하로 움직일때
                    if shark[i][3] == 1:
                        move = shark[i][0]-1 # row 1로 가기위한 이동횟수
                    else:
                        move = R-shark[i][0] # row R로 가기위한 이동횟수
                    if shark[i][2] <= move: # 방향이 한번도 바뀌지 않으면
                        if shark[i][3] == 1: # 단순히 방향대로 이동횟수를 빼거나 더하면됨
                            shark[i][0] -= shark[i][2]
                        else :
                            shark[i][0] += shark[i][2]
                    else: # 방향이 한 번 이상 바뀔 경우
                        rest = shark[i][2]-move 
                        if (rest//(R-1))%2==0: # 짝수이면 원래방향에서 바뀜
                            shark[i][3] = direction[shark[i][3]]
                        if shark[i][3] == 1:
                            shark[i][0] = R-rest%(R-1)
                        elif shark[i][3] == 2:
                            shark[i][0]=1+rest%(R-1)                        
                elif shark[i][3] == 3 or shark[i][3]==4: # 좌우로 움직일때
                    if shark[i][3] == 3:
                        move = C-shark[i][1] # col C로 가기위한 이동횟수
                    else:
                        move = shark[i][1]-1 # col 1로 가기위한 이동횟수
                    if shark[i][2] <= move: # 방향이 한번도 바뀌지 않으면
                        if shark[i][3] == 3: # 단순히 방향대로 이동횟수를 빼거나 더하면됨
                            shark[i][1] += shark[i][2]
                        else :
                            shark[i][1] -= shark[i][2]
                    else: # 방향이 한 번 이상 바뀔 경우
                        rest = shark[i][2]-move 
                        if (rest//(C-1))%2==0: # 짝수이면 원래방향에서 바뀜
                            shark[i][3] = direction[shark[i][3]]
                        if shark[i][3] == 3:
                            shark[i][1] = 1+rest%(C-1)
                        elif shark[i][3] == 4:
                            shark[i][1]=C-rest%(C-1)
                 # 한 칸에 상어 두 마리 이상이면 큰 크기가 잡아먹음
                if grid[shark[i][0]][shark[i][1]] != -1:
                    index2 = grid[shark[i][0]][shark[i][1]]
                    if shark[index2][4] > shark[i][4]: 
                        grid[shark[i][0]][shark[i][1]] = index2
                        shark[i] = [-1,-1,-1,-1,-1]
                    else:
                        grid[shark[i][0]][shark[i][1]] = i
                        shark[index2]=[-1,-1,-1,-1,-1]
                else:
                    grid[shark[i][0]][shark[i][1]]=i
    return sum
                   
R,C,M = map(int,input().split()) # R: 격자 행, C: 격자 열, M: 상어 수
grid = [[-1]*(C+1) for i in range(R+1)] # 격자판
shark = [] # 상어 정보
for i in range(M):
    r,c,s,d,z = map(int,input().split()) # row, col, 속력, 방향, 크기
    grid[r][c]=i # 격자판에 해당 상어에 해당하는 인덱스 저장
    shark.append(list([r,c,s,d,z]))

print(fishing(grid,shark))
    
