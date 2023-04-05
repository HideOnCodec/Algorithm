import java.util.*;
class Solution {
    public int solution(String s) {
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++){
            String result="";
            String past=s.substring(0,i);
            int cnt=1;
            for(int j=i; j<=s.length(); j+=i){
                int end = Math.min(j + i, s.length());
                String now=s.substring(j,end);
                if(past.equals(now)){
                    cnt++;
                }
                else {
                    if(cnt>=2){
                        result+=cnt;
                    }
                    result+=past;
                    past=now;
                    cnt=1;
                }
            }
            result+=past;
            if(min > result.length())
                min=result.length();
        }
        return min;
    }
}
