import java.util.*;
import java.util.stream.IntStream;
/**
i=0~
1번 : i % 5 + 1
2번 : {2,1,2,3,2,4,2,5} i % 8
3번 : {3,3,1,1,2,2,4,4,5,5} i % 10
*/
class Solution {
    public int[] solution(int[] answers) {
        int[][] rules = {{1,2,3,4,5},
                         {2,1,2,3,2,4,2,5},
                         {3,3,1,1,2,2,4,4,5,5}};
        
        int[] cnt = new int[3];
        int max = 0;
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                if(rules[j][i%rules[j].length] == answers[i])
                    max = Math.max(max,++cnt[j]);
            }
        }
        final int maxValue = max;
        return IntStream.range(0,3).filter(i -> cnt[i] == maxValue)
            .map(i -> i + 1).toArray();
    }
}