import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    static void search(Set<String> banSet, String[][] matchedUsers, int ban){
        if(ban == matchedUsers.length){
            result.add(new HashSet<>(banSet));
            return;
        }
        
        for(String user_id : matchedUsers[ban]){
            if(banSet.contains(user_id)) continue;
            banSet.add(user_id);
            search(banSet, matchedUsers, ban + 1);
            banSet.remove(user_id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        String[][] matchedUsers = Arrays.stream(banned_id)
            .map(ban -> ban.replace("*","."))
            .map(ban -> Arrays.stream(user_id)
                .filter(user -> user.matches(ban))
                .toArray(String[] :: new))
            .toArray(String[][] :: new);
        
        search(new HashSet<>(), matchedUsers, 0);
        return result.size();
    }
}