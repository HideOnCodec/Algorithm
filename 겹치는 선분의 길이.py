"""
프로그래머스 Lv0. 겹치는 선분의 길이
간단하게 -100 ~ 100까지의 x축을 나타내는 201 크기의 배열을 하나 생성한다.(list)
각 선분마다 해당하는 위치에 1을 더함으로써 색칠한다.
1보다 값이 큰 배열 값들은 선분이 겹치는 곳이므로 이 개수를 세면된다.
이 때 예를 들어 list[0],list[1],list[2]가 겹친 부분이라고 하면
겹치는 선분의 길이는 점의 개수가 아닌 선의 개수이므로 3이 아닌 2가된다.
따라서 0,1 혹은 1,2 부분만 1을 더하도록 한다.
"""

def solution(lines):
    list = [0 for i in range(201)]
    for i in range(len(lines)):
        start = lines[i][0]+100
        end = lines[i][1]+100
        for j in range(start,end):
            list[j]+=list[j]+1
    count = 0
    for i in range(0,202):
        if list[i] > 1:
            count+=1
    
    return count
