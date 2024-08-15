/**
 * 백준 16930번 달리기
 * BFS 알고리즘
 * 1초에 여러 칸을 갈 수 있으므로 중복 방문 시 분기를 고려해야한다.
 * 처음 방문하거나 재방문 시 이전에 방문했을 때보다 시간이 빠르면 큐에 넣어준다.
 * 만약 재방문했을 때와 이전 방문시 시간이 똑같을 경우 큐에 넣지는 않고 다음 칸 탐색을 진행한다. (벽에 막힌 케이스가 아니기 때문에)
 * 재방문했을 때 이전 방문보다 시간이 느리면 더 이상 탐색하지 않아야하므로 break
 */

 import java.util.*;
 import java.io.*;
 import java.awt.*;
 
 class Node{
     Point point;
     int time;
 
     public Node(Point point, int time){
         this.point = point;
         this.time = time;
     }
 }
 
 public class Main {
     static int n, m, k;
     static String map[] = new String[1001];
     static int visited[][] = new int[1001][1001];
     static int dx[] = {0, 0, 1, -1}; // 위, 아래, 오른쪽, 왼쪽
     static int dy[] = {-1, 1, 0, 0};
 
     static void bfs(int x1, int y1, int x2, int y2){
         Deque<Node> deque = new ArrayDeque<>();
         deque.add(new Node(new Point(x1, y1), 0));
         visited[y1][x1] = 1;
 
         while(!deque.isEmpty()){
             Node now = deque.poll();
             
             if(now.point.x == x2 && now.point.y == y2){
                 System.out.println(now.time);
                 return;
             }
 
             for(int i = 0; i < 4; i++){
                 for(int j = 1; j <= k; j++){ // 최대 k개 칸까지 
                     int nextX = now.point.x + dx[i] * j;
                     int nextY = now.point.y + dy[i] * j;
                     
                     if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) break;
                     if(map[nextY].charAt(nextX) == '#') break;
                     
                     if(visited[nextY][nextX] == 0 || visited[nextY][nextX] > now.time+1){
                         deque.add(new Node(new Point(nextX, nextY), now.time + 1));    
                         visited[nextY][nextX] = now.time + 1;
                     }
                     else if(visited[nextY][nextX]==now.time+1){
                        continue;
                     }
                     else break;
                 }
             }
         }
 
         System.out.println(-1); // 도착할 수 없는 경우
     }
 
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         n = Integer.parseInt(st.nextToken()); // y
         m = Integer.parseInt(st.nextToken()); // x
         k = Integer.parseInt(st.nextToken()); // 최대 이동 칸
 
         for(int i = 0; i < n; i++){
             map[i] = br.readLine();
         }
         st = new StringTokenizer(br.readLine()," ");
         int x1 = Integer.parseInt(st.nextToken());
         int y1 = Integer.parseInt(st.nextToken());
         int x2 = Integer.parseInt(st.nextToken());
         int y2 = Integer.parseInt(st.nextToken());
         bfs(y1 - 1, x1 - 1, y2 - 1, x2 - 1);
     }
 }
 
