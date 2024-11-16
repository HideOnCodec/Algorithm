import java.util.*;
/**
i=0~
1번 : i % 5 + 1
2번 : {2,1,2,3,2,4,2,5} i % 8
3번 : {3,3,1,1,2,2,4,4,5,5} i % 10
*/
class Solution {
    public int[] solution(int[] answers) {
        int sec[] = {2,1,2,3,2,4,2,5};
        int third[] = {3,3,1,1,2,2,4,4,5,5};
        
        int result[] = new int[3];
        for(int i=0; i<answers.length; i++){
            if(i % 5 + 1 == answers[i]) result[0]++;
            if(sec[i % 8] == answers[i]) result[1]++;
            if(third[i % 10] == answers[i]) result[2]++;
        }
        
        int max = Arrays.stream(result).max().orElse(0);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(result[i]==max) list.add(i+1);
        }
        
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}