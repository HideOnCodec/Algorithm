/**
 * 백준 1303번 전쟁 - 전투
 * DFS, BFS 문제
 */

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static String war[] = new String[101];
    static int visited[][] = new int[101][101];
    static int direction[][] = {{0,1},{0,-1},{-1,0},{1,0}}; // 하, 상, 좌, 우

    static int bfs(int x, int y){ 
        Deque<int[]> queue = new ArrayDeque<>();
        int point[] = {x,y}; // 시작 x,y 좌표 
        char nowColor = war[point[1]].charAt(point[0]); // 시작 좌표 기준 색상 
        queue.add(point);
        visited[y][x] = 1;
        
        int cnt = 1; // 뭉쳐있는 병사 수
        while(!queue.isEmpty()){
            point = queue.poll();

            for(int[] d : direction){ // 상 하 좌 우 탐색
                int newPoint[] = {point[0]+d[0],point[1]+d[1]}; 
                if(0 <= newPoint[0] && newPoint[0] < n && 0 <= newPoint[1] && newPoint[1] < m 
                    && visited[newPoint[1]][newPoint[0]]==0 && nowColor == war[newPoint[1]].charAt(newPoint[0])){ // 방문하지 않고 현재 색깔과 같으면 
                    cnt++;
                    queue.add(newPoint);
                    visited[newPoint[1]][newPoint[0]] = 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 

        
        for(int i=0; i<m; i++){
            war[i] = br.readLine();
        }
        int wSum = 0;
        int bSum = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==0){
                    int cnt = bfs(j,i);
                    if(war[i].charAt(j)=='W') 
                        wSum += cnt*cnt;
                    else {
                        bSum += cnt*cnt;
                    }
                }
            }
        }
        System.out.println(wSum+" "+bSum);
        
    }
}
