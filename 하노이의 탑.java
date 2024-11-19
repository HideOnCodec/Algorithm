import java.util.*;
/**
상태 : (n, from, to)
종료 조건 : n == 1
점화식 : (n, from, to) = (n-1, from, empty) + (1, from, to) + (n-1, empty, to)
empty == 6 - from - to (1번, 2번, 3번 기둥이므로)
*/
class Solution {
    static void hanoi(int n, int from, int to, List<int[]> path){
        if(n == 1){
            path.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;
        hanoi(n-1, from, empty, path);
        hanoi(1, from, to, path);
        hanoi(n-1, empty, to, path);
    }
    
    public int[][] solution(int n) {
        List<int[]> path = new ArrayList<>();
        hanoi(n, 1, 3, path);
        return path.toArray(new int[0][]);
    }
}