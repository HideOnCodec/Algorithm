/**
 * 백준 2252번 줄 세우기
 * 위상 정렬
 * 진입 차수(indegree) : 들어오는 간선의 개수
 * 진출 차수(outdegree) : 나가는 간선의 개수          
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();
        int indegree[] = new int[n+1]; // 진입 차수 배열
        List<Integer> result = new ArrayList<>(); // 결과 리스트 

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v).add(w); // v -> w
            indegree[w]++; // w 진입 차수 증가
        }

        // 위상 정렬

        // 진입 차수가 0인 정점 먼저 추가
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.pop();
            result.add(node); // 진입 차수 0일 때 추가
            // node가 출발 정점인 간선 삭제  
            for(int i=0; i<graph.get(node).size(); i++){
                int w = graph.get(node).get(i);
                indegree[w]--; 
                if(indegree[w]==0)
                    queue.offer(w);
            }
        }

        for(Integer student : result){
            System.out.print(student+" ");
        }
    }
}
