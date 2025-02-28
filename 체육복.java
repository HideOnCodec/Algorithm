import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int students[] = new int[n];
        for(int i = 0; i < lost.length; i++){
            students[lost[i] - 1] = -1;
        }
        for(int i = 0; i < reserve.length; i++){
            students[reserve[i] - 1] += 1;
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(students[i] >= 0){ // 체육복이 있는 학생인 경우
                cnt++;
            }
            else if(students[i] == -1){ // 도난당한 학생인 경우
                if(i > 0 && students[i - 1] == 1){
                    cnt++;
                    students[i - 1] = 0;
                }
                else if(i < n - 1 && students[i + 1] == 1){
                    cnt++;
                    students[i + 1] = 0;
                }        
            }
        }
        
        return cnt;
    }
}
