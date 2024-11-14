import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int map[][] = new int[51][51];
    static int max = 0; // 최대 거리
    static int maxSum = 0; // 최대 거리일 때 시작과 끝의 합

    static void bfs(int n, int m, int y, int x){
        int[][] visited = new int[n][m];
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[y][x]=1;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(max<visited[point.y][point.x]){
                max = visited[point.y][point.x];
                maxSum = map[y][x]+map[point.y][point.x];
            }
            else if(max == visited[point.y][point.x]){
                maxSum = Math.max(maxSum,map[y][x]+map[point.y][point.x]);
            }

            for(int i=0; i<4; i++){
                int newX = point.x+dx[i];
                int newY = point.y+dy[i];
                if(0<=newX&&newX<m && 0<=newY&&newY<n && visited[newY][newX]==0 && map[newY][newX]!=0){
                    visited[newY][newX]=visited[point.y][point.x]+1;
                    queue.add(new Point(newX,newY));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++)
                map[i][j]= Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]!=0){
                    bfs(n,m,i,j);
                }
            }
        }

        System.out.println(maxSum);

    }
}

