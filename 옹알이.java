import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        List<String> list= Arrays.asList("aya", "ye", "woo", "ma" );
        int cnt=0;
        for(int i=0; i<babbling.length; i++){
            String token="";
            String past="";
            for(int j=0; j<babbling[i].length(); j++){
                token+=babbling[i].charAt(j);
                if(list.contains(token)&&!past.equals(token)){
                    past=token;
                    token="";
                }
            }
            if(token=="")
                cnt++;
        }
        return cnt;
    }
}
