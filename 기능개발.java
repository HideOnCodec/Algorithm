import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int q = (100 - progresses[i]) / speeds[i];
            queue.add(progresses[i] + speeds[i] * q >= 100 ? q : q + 1);
        }
        
        int day = queue.peek();
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(day >= n) cnt++;
            else{
                result.add(cnt);
                cnt = 1;
                day = n;
            }
        }
        
        if(cnt > 0) result.add(cnt);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}