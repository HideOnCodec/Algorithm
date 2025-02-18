import java.util.*;

class Solution { 
    static void bfs(int[] visited, int[][] computers, int index){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(index);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i = 0; i < computers[now].length; i++){
                int isConnected = computers[now][i];
                if(isConnected == 1 && visited[i] == 0){
                    queue.add(i);
                    visited[i] = 1;
                }
            }  
        }
    }
    
    public int solution(int n, int[][] computers) {
        int[] visited = new int[computers.length];
        int cnt = 0;
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == 0){
                bfs(visited, computers, i);
                cnt++;
            }
        }
        
        return cnt;
    }
}