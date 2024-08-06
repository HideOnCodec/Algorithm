/**
 * 백준 1916번 최소 비용 구하기
 * 벨만포드 알고리즘
 */

import java.util.*;
import java.io.*;

class Bus{
    int v; // 출발 도시
    int w; // 도착 도시
    int cost; // 비용

    public Bus(int v, int w, int cost){
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}
public class Main {
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수

        int dist[] = new int[n+1]; // 최소 비용 배열 
        Arrays.fill(dist, INF);
        List<Bus> graph = new ArrayList<>();

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            graph.add(new Bus(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 벨만 포드
        dist[start] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Bus bus = graph.get(j);
                
                if(dist[bus.v]!=INF && dist[bus.w]>dist[bus.v]+bus.cost){
                    dist[bus.w] = dist[bus.v] + bus.cost;
                }
            }
        }

        System.out.println(dist[end]);

    }
}
