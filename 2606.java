/**
 * 백준 2606번 바이러스
 * bfs/dfs 알고리즘 
 */

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();

    static int dfs(int[] visited){
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        
        while(!stack.isEmpty()){
            int node = stack.pop();

            if(visited[node]==0){
                visited[node]=1;
                cnt++;
            
                for(int n : graph.get(node)){
                    if(visited[n]==0){
                        stack.push(n);
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        for(int i=0; i<=computer; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향 그래프
        }
        int visited[] = new int[computer+1];
        System.out.println(dfs(visited)-1);
    }
}
