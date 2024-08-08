/**
 * 백준 1743번 음식물 피하기
 * bfs/dfs 알고리즘 
 * 제발 Point 사용할 때는 Point(x,y)로 집어넣고 사용합시다...
 */

import java.util.*;
import java.awt.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int map[][] = new int[101][101];
    static int visited[][] = new int[101][101];   
    static int dx[] = {0,1,-1,0}; // 하, 우, 좌, 상
    static int dy[] = {1,0,0,-1};  

    static int bfs(int y, int x){
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x,y));
        visited[y][x] = 1;
        int cnt = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int nextY = point.y + dy[i];
                int nextX = point.x + dx[i];
                // 벽을 안 넘고, 방문하지 않았고, 음식물 쓰레기가 있으면
                if(1<=nextY&&nextY<=n && 1<=nextX&&nextX<=m && visited[nextY][nextX]==0 && map[nextY][nextX] == 1){
                    queue.add(new Point(nextX,nextY));
                    visited[nextY][nextX] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x
        k = Integer.parseInt(st.nextToken()); // 음식물 개수
        
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==1&&visited[i][j]==0){
                    int cnt = bfs(i,j);
                    if(cnt > max) max = cnt;
                }
            }
        }

        System.out.println(max);
    }
}
