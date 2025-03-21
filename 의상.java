import java.util.*;

class Solution {    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        int sum = 1;
        for(Integer num : map.values()){
            sum *= num + 1;
        }
        
        return sum - 1;
    }
}
