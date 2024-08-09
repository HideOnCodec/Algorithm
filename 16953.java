/**
 * 백준 16953번 A -> B
 * bfs 알고리즘 
 * dfs -> 시간 초과이므로 최단 경로 찾기가 빠른 bfs
 * 메모리 초과 문제로 인하여 visited 배열이 아닌 map으로 구현
 * 최댓값으로 했을 때 실행은 잘 됐으나 백준에서는 정수 오버플로우가 발생해서 틀렸다...Long으로 할 것!
 */

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.*;

public class Main {
    static Map<Long,Integer> visited = new HashMap<>();

    static void bfs(Long a,Long b){
        Deque<Long> deque = new ArrayDeque<>();
        deque.add(a);
        visited.put(a,1);

        while(!deque.isEmpty()){
            Long num = deque.poll();
            int visitCount = visited.get(num);

            if(num*2<=b && !visited.containsKey(num*2)){ // 곱하기 2
                deque.add(num*2);
                visited.put(num*2,visitCount+1);
            }
            if(num*10+1<=b && !visited.containsKey(num*10+1)){ // 뒤에 1 붙이기
                deque.add(num*10+1);
                visited.put(num*10+1,visitCount+1); // 횟수 저장 
            }   
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        bfs(a,b);
        System.out.println(visited.containsKey(b) ? visited.get(b) : -1);
    }
}
