import java.util.*;

class Solution {    
    static boolean isValidTime(int[] times, long limit, int n){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum += limit / times[i];
            if(sum >= n){
                return true;
            }
        }
        
        return false;
    }
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int total = times.length; // 심사관 수
        long left = 1L;
        long right = (long)n * times[total - 1];
        
        long minTime = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            if(isValidTime(times, mid, n)){
                minTime = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return minTime;
    }
}
