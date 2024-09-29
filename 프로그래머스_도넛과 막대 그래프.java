import java.util.*;
/**
막대
1. 막대 모형 끝일 경우 : 아웃 0 
2. 막대 모형 처음인 경우 : 진입 1, 아웃 1 
3. 막대 모형 중간 : 진입 2, 아웃 1
8자
1. 8자 모형 가운데 외 : 진입 2, 아웃 1
2. 8자 모형 가운데인 경우 : 진입 3, 아웃 2 
도넛
1. 도넛 모형 : 진입 2, 아웃 1
*/
class Solution {
    static Map<Integer,Integer> visited = new HashMap<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree = new int[1000000];  
    static int[] ans = new int[4];
 
    public static void dfs(int node){
        if(visited.get(node)==1){ // 한바퀴를 모두 돌았으면 도넛
            ans[1]++;
            return;
        }
        if(indegree[node]==2 && graph.get(node).size()==2){ // 8자 가운데를 찾으면
            ans[3]++;
            return;
        }
        if(graph.get(node).size()==0){ // 진출 차수가 0이면 막대
            ans[2]++;
            return;
        }
            
        visited.put(node,1);
        for(int n : graph.get(node))
            dfs(n);
    }
    
    public int[] solution(int[][] edges) {
        
        for(int i=0; i<1000000; i++){ // 그래프 초기화
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int v = edges[i][0]; // v -> w
            int w = edges[i][1]; 
            visited.put(v,0);
            visited.put(w,0);
            indegree[w]++; // 진입 차수 증가
            graph.get(v).add(w); 
            if(graph.get(v).size()>=2 && indegree[v]==0){
                ans[0]=edges[i][0]; // 생성 정점 확인
            }
        }
        
        for(int n : graph.get(ans[0])){
            int out = graph.get(n).size();
            if(out==0 || (out==1 && indegree[n]==1)) // 막대 모형 끝 또는 시작
                ans[2]++;
            else if(out==2 && indegree[n] ==3) // 8자 모형 가운데
                ans[3]++;
            else{
                dfs(n);
            }
        }
        
        return ans; 
        
    }
}

/**
dfs를 사용하지 않는 정석 답 
*/
import java.util.*;

class Solution {
    static int[] indegree = new int[1000000];  
    static int[] outdegree = new int[1000000];  
    static int[] ans = new int[4];
    
    public int[] solution(int[][] edges) {
        for(int i=0; i<edges.length; i++){
            int v = edges[i][0]-1; // v -> w
            int w = edges[i][1]-1; 
            indegree[w]++; // 진입 차수 증가
            outdegree[v]++; // 진출 차수 증가
            if(outdegree[v]>=2 && indegree[v]==0){
                ans[0]=v+1; // 생성 정점 확인
            }
        }

        for(int i=0; i<1000000; i++){
            if(outdegree[i]==0&&indegree[i]>=1)// 막대모형 끝
                    ans[2]++;
            else if(indegree[i]>=2 && outdegree[i]==2) // 8자 모형
                ans[3]++;
        }
        
        ans[1] = outdegree[ans[0]-1]-(ans[2]+ans[3]); // 생성 정점의 진출 차수에서 막대 + 8자 수를 뺀 값 = 도넛 
        return ans; 
        
    }
}
