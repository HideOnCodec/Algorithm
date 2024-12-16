import java.util.*;

class Solution {
    static int max(int start, int end, String arr[], int[][] maxMem, int[][] minMem){
        if(maxMem[start][end] != Integer.MIN_VALUE){
            return maxMem[start][end];
        }
        if(end - start == 1) return Integer.parseInt(arr[start]);
        
        int max = Integer.MIN_VALUE;
        for(int i = start + 1; i < end; i += 2){
            int left = max(start, i, arr, maxMem, minMem);
            if(arr[i].equals("+")){
                int right = max(i + 1, end, arr, maxMem, minMem);
                max = Math.max(max, left + right);
            }
            else{
                int right = min(i + 1, end, arr, maxMem, minMem);
                max = Math.max(max, left - right);
            }
        }
        maxMem[start][end] = max;
        return max;
    }
    
    static int min(int start, int end, String arr[], int[][] maxMem, int[][] minMem){
        if(minMem[start][end] != Integer.MAX_VALUE){
            return minMem[start][end];
        }
        if(end - start == 1) return Integer.parseInt(arr[start]);
        
        int min = Integer.MAX_VALUE;
        for(int i = start + 1; i < end; i += 2){
            int left = min(start, i, arr, maxMem, minMem);
            if(arr[i].equals("+")){
                int right = min(i + 1, end, arr, maxMem, minMem);
                min = Math.min(min, left + right);
            }
            else{
                int right = max(i + 1, end, arr, maxMem, minMem);
                min = Math.min(min, left - right);
            }
        } 
        minMem[start][end] = min;
        return min;
    }
    
    public int solution(String arr[]) {
        int[][] maxMem = new int[203][203];
        int[][] minMem = new int[203][203];
        
        for(int i = 0; i < 203; i++){
            Arrays.fill(maxMem[i], Integer.MIN_VALUE);
            Arrays.fill(minMem[i], Integer.MAX_VALUE);
        }
        return max(0, arr.length, arr, maxMem, minMem);
    }
}

/**
+ -> 양쪽이 max()
- -> 왼쪽은 max(), 오른쪽 min()
*/