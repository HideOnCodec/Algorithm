import java.util.*;

class Solution {
    static boolean isChangeable(String before, String after){
        int cnt = 0;
        for(int i = 0; i < before.length(); i++){
            if(before.charAt(i) != after.charAt(i)){
                cnt++;
            }
        }
        
        return cnt == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        
        visited.put(begin, 0);
        for(int i = 0; i < words.length; i++){
            visited.put(words[i], 0);
        }
        queue.offer(begin);
        
        while(!queue.isEmpty()){
            String now = queue.poll();
            if(now.equals(target)){
                return visited.get(now);
            }
            
            for(int i = 0; i < words.length; i++){
                if(visited.get(words[i]) == 0 && isChangeable(now, words[i])){
                    queue.offer(words[i]);
                    visited.put(words[i], visited.get(now) + 1);
                }
            }
        }
        
        return 0;
    }
}
