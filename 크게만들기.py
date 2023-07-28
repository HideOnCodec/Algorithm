"""
백준 1715번 크게만들기
stack을 이용하여 pop,push를 반복하며 푸는 문제

디테일한 요소를 생각해야되는 문제이다.
처음 숫자는 무조건 stack에 들어간다. 그 다음 자리 숫자부터 차례대로 stack Top에 있는 숫자와 비교하면 된다.
while문을 이용하여 stack이 비어있지 않고, stack Top에 있는 숫자보다 지금 숫자가 더 크고, 지울 수 있는 갯수가 남아있으면
stack Top을 지운다.(처음에 나는 while문을 사용하지 않고 Top과 한번만 비교했는데 이렇게 되면 최선이 될 수 없다.)
예제 : 만약 98799 라는 숫자에서 2개를 지워야할 경우, while문으로 stack과 계속 비교하지 않고 한번만 비교한다면 999가 아닌 989가 stack에 들어간다.
결국 stack에 있는 숫자들이 현재 숫자보다 작다면 계속 지워줘야한다. 그리고 지울 수 있는 갯수 cnt를 줄인다.
stack push는 while문이 끝나고 실행해야한다. 어쨋든 현재 숫자는 넣어줘야한다.

이 때 두 가지 경우를 고려해줘야한다.
1) N == K 인 경우 : 모든 숫자가 지워지므로 아무것도 출력하지 않고 끝낸다.
2) for문이 끝나고도 cnt가 남는 경우 : 이런 경우가 생길 수 있나? 싶었는데 그런 경우가 생길 수 있었다..
예제 입력 
2 1 
11
이 경우 숫자가 모두 같기 때문에 하나도 지워지지 않고 11이 스택에 들어간다. 이 경우 스택 뒤에서부터 남은 cnt만큼 pop해준다.
(어차피 맨 앞 숫자는 스택 Top에 있던 숫자들을 모두 지우면서 들어간 최상의 숫자이기 때문에 뒤에서부터 지우는 것이 맞다.)
"""

N, K = map(int,input().split())
if N == K:
    print()
    exit()
num = input()
numList=[]
for i in range(N):
    numList.append(int(num[i]))
cnt=K
stack =[]
stack.append(num[0])
for i in range(1,N):
    while stack and stack[len(stack)-1] < num[i] and cnt>0 :
        stack.pop()
        cnt-=1
    stack.append(num[i])

if cnt>0:
    for i in range(cnt):
        stack.pop()
for i in stack:
    print(i,end='')  
