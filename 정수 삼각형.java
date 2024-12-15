import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int mem[][] = new int[len][triangle[len - 1].length];
        mem[0][0] = triangle[0][0];
        
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < triangle[i].length; j++){
                mem[i+1][j] = Math.max(mem[i+1][j], triangle[i+1][j] + mem[i][j]);
                mem[i+1][j+1] = Math.max(mem[i+1][j+1], triangle[i+1][j+1] + mem[i][j]);
            }
        }
        
        return Arrays.stream(mem[len - 1]).max().getAsInt();
        
    }
}