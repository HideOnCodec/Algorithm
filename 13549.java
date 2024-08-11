/**
 * 백준 13549번 숨바꼭질 3
 * bfs 알고리즘
 */

 import java.util.*;
 import java.util.List;
 import java.awt.*;
 import java.io.*;

 public class Main {
    static Boolean[] visited = new Boolean[200002];
    static int[] dist = new int[200002];

    static void bfs(int n, int k){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        visited[n]=true;
        dist[n] = 0;

        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            if(n==k) continue;
            if(now*2<=100000 && (!visited[now*2]||dist[now*2]>dist[now])){
                deque.add(now*2);
                visited[now*2]=true;
                dist[now*2]=dist[now];
            }
            int operation[] = {now+1,now-1};
            for(int next : operation){
                if(0<=next && next<=100000 && (!visited[next]||dist[next]>dist[now]+1)){
                    deque.add(next);
                    visited[next]=true;
                    dist[next] = dist[now] + 1;
                }
            }
            
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Arrays.fill(visited,false);
        bfs(n,k);
        System.out.println(dist[k]);
    }
 }
 
