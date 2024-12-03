import java.util.*;

class Solution {
    static boolean isValid(int[] times, int n, long mid){
        for(int time : times){
            n -= mid / time;
            if(n <= 0){
                break;
            }
        }
        return n <= 0;
    }
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long end = (long)times[0] * n; // long * int == long
        long mid = start;
        
        while(start < end){
            mid = (start + end) / 2;
            if(isValid(times, n, mid)){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        return start;
    }
}

/**
이진 탐색
start = 최소 심사 시간, end = n * 최소 심사 시간
7 10 20  -> 20분
2 2  1
*/

