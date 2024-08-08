/**
 * 백준 2178번 미로 탐색
 * bfs 알고리즘 
 */

import java.util.*;
import java.awt.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int map[][] = new int[100][100];
    static int visited[][] = new int[100][100];
    static int direction[][] = {{0,1},{0,-1},{1,0},{-1,0}}; // 우, 좌, 하, 상
    
    static void bfs(){
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            for(int[] d : direction){
                int newY = now.y+d[0];
                int newX = now.x+d[1];
                if(0<=newY&&newY<n && 0<=newX&&newX<m && visited[newY][newX]==0 && map[newY][newX]!=0){
                    queue.add(new Point(newX,newY));
                    visited[newY][newX] = 1;
                    map[newY][newX] = map[now.y][now.x] + 1;
                }
            }
        }
    }            

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        bfs();
        System.out.println(map[n-1][m-1]);

    }
}
