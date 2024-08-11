/**
 * 백준 13913번 숨바꼭질 4
 * bfs 알고리즘
 * 처음에 노드 클래스 만들어서 리스트를 복사하며 넣었더니 시간초과
 * 역추적 방식으로 출력하기!
 */

 import java.util.*;
 import java.util.List;
 import java.awt.*;
 import java.io.*;


 public class Main {
    static int visited[] = new int[200001];
    static int dist[][] = new int[200001][2]; // 0: 거리, 1: 이전 노드
    static int n;
    static int k;
    
    static void bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        visited[n] = 1;
        dist[n][0] = 0;
        dist[n][1] = -1;

        while(!deque.isEmpty()){
            int now = deque.poll();

            if(now == k) {
                List<Integer> result = new ArrayList<>();
                int node = k;
                result.add(node);
                while(node!=-1){
                    if(dist[node][1]!=-1)
                        result.add(dist[node][1]);
                    node = dist[node][1];
                }
                System.out.println(dist[k][0]);
                for(int i=result.size()-1; i>=0; i--)
                    System.out.print(result.get(i)+" ");
                return;
            }

            int operation[] = {now+1,now-1,now*2};
            for(int next : operation){
                if(0<=next&&next<=100000&&visited[next]==0){
                    deque.add(next);
                    visited[next]=1;
                    dist[next][0]=dist[now][0]+1;
                    dist[next][1]=now;
                }
            }
        }

    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        bfs();
    }
 }
 
