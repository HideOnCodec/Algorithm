import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            List<Integer> newArray = new ArrayList<>();
            for(int j = commands[i][0]-1; j<=commands[i][1]-1; j++){
                newArray.add(array[j]);
            }
            Collections.sort(newArray);
            answer[i] = newArray.get(commands[i][2]-1);
        }
        return answer;
    }
}