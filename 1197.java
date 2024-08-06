/**
 * 백준 1197번 최소 스패닝 트리
 * 크루스칼 알고리즘
 */

import java.util.*;
import java.io.*;

class Edge{
    int v;
    int w;
    int cost;

    public Edge(int v, int w, int cost){
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}

public class Main {
    static int root[] = new int[10001];
    static int v;
    static int e;

    static int getParent(int v){
        if(root[v]==v) return v;
        return getParent(root[v]);
    }

    static void setUnion(int a, int b){
        int rootA = getParent(a);
        int rootB = getParent(b);
        if(rootA<rootB) root[rootB] = rootA;
        else root[rootA] = rootB;
    }

    static Boolean isCycle(int a, int b){
        return (getParent(a)==getParent(b));
    }

    static int kruskal(List<Edge> graph){
        int sum = 0;
        for(int i=1; i<=v; i++)
            root[i] = i; // 초기에는 자기 자신이 부모 

        for(Edge edge : graph){
            if(!isCycle(edge.v, edge.w)){
                sum += edge.cost;
                setUnion(edge.v, edge.w);
            }
        }
        
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        v = Integer.parseInt(st.nextToken()); // 정점 개수
        e = Integer.parseInt(st.nextToken()); // 간선 개수

        List<Edge> graph = new ArrayList<>();

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            graph.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(graph, (e1,e2)-> Integer.compare(e1.cost,e2.cost));

        System.out.println(kruskal(graph));

    }
}
