import java.util.*;
/**
1~s길이/2까지 단위 탐색 
    해당 단위만큼 문자열을 잘라서 탐색 
        a. 이전과 반복되면 반복된 수 저장
        b. 반복되지 않으면 마지막 반복 수 + 문자열 붙여서 append, 반복수 초기화
*/
class Solution {
    public int solution(String s) {
        int min = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            int cnt = 1;
            String past = s.substring(0,i);
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<s.length(); j+=i){
                int end = Math.min(j+i,s.length());
                String now = s.substring(j,end);
                if(past.equals(now))
                    cnt++;
                else{
                    sb.append(cnt==1 ? past : cnt+past);
                    cnt=1;
                }
                past = now;
            }
            sb.append(cnt==1 ? past : cnt+past);
            min = Math.min(min,sb.toString().length());
        }
        return min;
    }
}
