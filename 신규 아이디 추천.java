import java.util.*;
/**
3~15자 인지, ".."을 포함하거나 처음과 끝에 '.'가 있는지, [a-z0-9\-\.\_]
*/
class Solution {    
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9\\-._]","");
        // 3단계
        new_id = new_id.replaceAll("\\.+",".");
        // 4단계
        new_id = new_id.replaceAll("^\\.|\\.$","");
        // 5단계
        if(new_id.length()==0) new_id+="a";
        // 6단계
        else if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.$","");
        }
        // 7단계
        if(new_id.length()<=2){
            char c = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3){
                new_id+=c;
            }
        }
        return new_id;
    }
}