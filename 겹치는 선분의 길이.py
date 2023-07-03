def solution(lines):
    list = [0 for i in range(201)]
    for i in range(len(lines)):
        start = lines[i][0]+100
        end = lines[i][1]+100
        for j in range(start,end):
            list[j]+=list[j]+1
    count = 0
    for i in range(0,201):
        if list[i] > 1:
            count+=1
    
    return count
