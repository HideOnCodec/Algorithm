import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] info;
    static int max = 0;
    
    static void search(Set<Integer> nodeSet, int sheep, int wolf, int node){       
        if(info[node] == 0){
            sheep++;
        }
        else{
            wolf++;
        }
        
        if(sheep <= wolf){
            return;
        }
        max = Math.max(sheep, max);
        
        Set<Integer> nextNodes = new HashSet<>(nodeSet);
        nextNodes.addAll(graph.get(node));
        nextNodes.remove(node);
        
        for(int next : nextNodes){
            search(nextNodes, sheep, wolf, next);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        for(int i = 0; i < info.length; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        search(new HashSet<>(), 0, 0, 0);
        return max;
    }
}
