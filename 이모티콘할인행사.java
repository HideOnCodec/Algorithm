import java.util.*;

class Solution {
    static int maxPrice = 0;
    static int maxJoin = 0;
    static int[] visited = new int[8];
    
    public static void dfs(int emo, int[][] users, int[] emoticons){
        if(emo==emoticons.length){
            int totalPrice = 0;
            int join = 0;
            for(int i=0; i<users.length; i++){
                Double price = 0.0;
                for(int j=0; j<emoticons.length; j++){
                    if(users[i][0]<=visited[j])
                        price+=emoticons[j]*((100-visited[j])/100.0);
                }
                if(price>=users[i][1]){
                    join++;
                }
                else
                    totalPrice+=price;
            }
            // 조건에 따라 최적의 값 갱신
            if (join > maxJoin || (join == maxJoin && totalPrice > maxPrice)) {
                maxJoin = join;
                maxPrice = totalPrice;
            }
            return;
        }
        
        for(int i=10; i<=40; i+=10){
            visited[emo]=i;
            dfs(emo+1,users,emoticons);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0,users,emoticons);
        int[] result = {maxJoin,maxPrice};
        return result;
    }
}
