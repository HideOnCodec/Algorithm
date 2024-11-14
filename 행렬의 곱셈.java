import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int c = 0; c < arr2.length; c++)
                    result[i][j]+=arr1[i][c]*arr2[c][j];
            }
        }
        
        return result;
    }
}
