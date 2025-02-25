import java.io.*;
import java.util.*;

class Node{
    int v;
    int cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main{
    static List<Node>[] graph;
    static final int INF = 200000000;
    static int[] dijkstra(int n, int start){
        int dist[] = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.cost > dist[node.v]) continue;
            
            for(Node next : graph[node.v]){
                if(dist[next.v] > dist[node.v] + next.cost){
                    dist[next.v] = dist[node.v] + next.cost;

                    pq.offer(new Node(next.v, dist[next.v]));
                } 
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st. nextToken());
            int b = Integer.parseInt(st. nextToken());
            int cost = Integer.parseInt(st. nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(n, 1);
        int[] distV1 = dijkstra(n, v1);
        int[] distV2 = dijkstra(n, v2);
        // 1 -> v1, v1 -> v2, v2 -> N 최소 거리의 합
        int result1 = dist[v1] + distV1[v2] + distV2[n];

        // 1 -> v2, v2 -> v1, v1 -> N 최소 거리의 합
        int result2 = dist[v2] + distV2[v1] + distV1[n];

        int answer = Math.min(result1, result2);

        System.out.println(answer >= INF ? -1 : answer);
    }
}

/**
 1 -> N 최소 거리가 목표, 단 v1, v2를 그 사이에 무조건 방문
 1 -> .. -> v1 -> .. -> v2 -> .. -> N
 1 -> .. -> v2 -> .. -> v1 -> .. -> N

 1. 1 -> v1, v1 -> v2, v2 -> N 최소 거리의 합
 2. 1 -> v2, v2 -> v1, v1 -> N 최소 거리의 합
 두 개를 구한 후 비교
 3. 두 개 모두 Integer.MAX_VALUE(즉 경로가 없는 경우!)인 경우 -1 출력 

 O((n + e)log(v)) = O(200,800 * log(800)) = 대략 180만, 180만 * 6

 */