"""
백준 1525번 퍼즐
BFS를 이용하여 푸는 문제이다.

시간제한, 메모리제한이 있기 때문에 BFS를 이용하고 2차원리스트가 아닌 String으로 퍼즐을 구현한다.
구현 방식:
1. 첫 시작 퍼즐을 start에 string으로 받는다.
2. queue에 start,count(초기값=0)를 넣고 queue에서 pop한 퍼즐 문자열을 string에 저장한다.
3. string에서 0의 index를 찾아 zeroNear에서 근접 숫자 리스트를 받는다.
4. 이 리스트를 돌며 각각 빈칸으로 숫자를 옮길 수 있는 모든 퍼즐 모양을 문자열로 list1에 저장한다.
5. list1을 돌며 각각의 모양이 visted에 이미 존재하면 넘어가고, 처음 나오는 모양이면 큐에 넣는다.(count+1 값도 같이 넣어준다)
6. 이 과정을 큐가 빌때까지 반복한다. 이 과정에서 큐에 pop한 값이 "123456780"로 완성된 모양이 되면 count를 1 늘려주고 즉시 종료한다.

실수했던 점:
1. 사소한거지만 큐에서 pop할 때 pop(0)이라고 하자..(pop()은 스택처럼 된다)
2. 시간제한이 중요하기 때문에 Hash를 사용하는 딕셔너리를 이용하여 visited를 구현하자(리스트는 시간초과가 발생한다)
3. 큐에서 pop한 퍼즐 모양을 통해 구한 인접 숫자들의 퍼즐 모양들은 모두 같은 count값을 가져야한다. (갈림길로 생각하면 편한다)
4. count값은 큐에 같이 넣음으로써 구현하는 것이 좋다.(에러 발생 요인)
"""
import sys
input = sys.stdin.readline
# 0의 위치마다 인접 숫자의 리스트를 구현한 딕셔너리
zeroNear = {0:[1,3],1:[0,2,4],2:[1,5],3:[0,4,6],4:[1,3,5,7],5:[2,4,8],6:[3,7],7:[6,4,8],8:[5,7]}
# 0의 자리로 인접 숫자를 옮기는 함수
def exchange(str,a,b): # a:0의 인덱스, b:0 자리로 갈 문자의 인덱스
    toInt = list(str)
    tmp = str[b]
    toInt[b] = string[a]
    toInt[a] = tmp
    str = ''.join(c for c in toInt)
    return str

visited = {} # Hash 사용으로 list보다 빠름
puzzle =[list(input().split()) for i in range(3)]
start=""
for i in range(3):
    start+=puzzle[i][0]+puzzle[i][1]+puzzle[i][2]
count=0

queue = []
queue.append([start, count])
while(queue):
    string, cnt = queue.pop(0)
    if string == "123456780":
        print(cnt)
        exit()
    index = string.find('0') # 0의 인덱스
    nearList = zeroNear[index]
    list1=[] # 0과 인접한 숫자들을 0으로 옮겼을 때의 string 
    for i in nearList:
        list1.append(exchange(string,index,i))
    for s in list1:
        if s in visited:
            continue
        else:
            visited[s]=cnt
            queue.append([s,cnt+1])

print(-1)
