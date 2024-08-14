/**
 * 백준 17086번 아기 상어 2
 * BFS 알고리즘
 */

import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;

public class Main {
    static int map[][] = new int[51][51];
    static int n;
    static int m;
    static int dx[] = {0,1,-1,0,1,-1,1,-1}; // 아래, 우, 좌, 상, 오른쪽 위, 왼쪽 위, 오른쪽 아래, 왼쪽 아래
    static int dy[] = {1,0,0,-1,-1,-1,1,1};

    static int bfs(int y, int x){
        Deque<Point> deque = new ArrayDeque<>();
        int visited[][] = new int[51][51];
        deque.add(new Point(x,y));
        visited[y][x]=1;

        while(!deque.isEmpty()){
            Point now = deque.pop();
            
            if(map[now.y][now.x]==1){
                return visited[now.y][now.x]-1;
            }

            for(int i=0; i<8; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(0<=nextX&&nextX<=m && 0<=nextY&&nextY<=n && visited[nextY][nextX]==0){
                    deque.add(new Point(nextX,nextY));
                    visited[nextY][nextX]=visited[now.y][now.x]+1;
                }
            }
        }

        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    int result = bfs(i,j);
                    if(max<result) max = result;
                }
            }
        }

        System.out.println(max);
    }
}
 
