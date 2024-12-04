import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> finish = new HashMap<>();
        for(String player : completion){
            finish.put(player, finish.getOrDefault(player,0) + 1);
        }
        
        String result = "";
        for(String player : participant){
            if(!finish.containsKey(player) || finish.get(player) == 0){
                result = player;
                break;
            }
            else{
                finish.put(player, finish.get(player) - 1);
            }
        }
        
        return result;
    }
}
