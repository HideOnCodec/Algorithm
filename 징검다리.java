import java.util.*;

class Solution {
    static boolean isValid(int[] rocks, int n, int mid) {
        int removed = 0;
        int last = 0; // 마지막 바위 위치
        
        for (int rock : rocks) {
            if (rock - last < mid) {
                removed++;
            } else {
                last = rock;
            }
        }
        
        return removed <= n;
        // n개를 제거했을 때의 최댓값보다 n개 미만을 제거했을 때의 최댓값이 항상 같거나 작음 
    }
    
    static int binarySearch(int distance, int[] rocks, int n) {
        int start = 1; 
        int end = distance;
        int max = 0; // 최소 거리의 최댓값 저장

        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (isValid(rocks, n, mid)) {
                max = Math.max(max, mid); // 조건을 만족하면 최댓값 갱신
                start = mid + 1; // 더 큰 최소 거리를 탐색
            } 
            else{
                end = mid - 1; // 바위가 더 많이 제거된 경우 거리 축소
            }
        }
        
        return max;
    }
    
    public int solution(int distance, int[] rocks, int n) {  
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance; // 종점 추가
        Arrays.sort(rocks); // 바위 위치 정렬
        return binarySearch(distance, rocks, n);
    }
}
