import java.util.*;
class Solution {
    public String solution(String new_id) {
        //1단계
        String answer = new_id.toLowerCase();
        //2단계
        answer = answer.replaceAll("[^-._0-9a-z]","");
        //3단계
        while(answer.contains("..")){
            answer=answer.replace("..", ".");
        }
        //4단계
        if(answer.length()>0){
            if(answer.charAt(0)=='.')
                answer=answer.substring(1,answer.length());
        }
        if(answer.length()>0){
            if(answer.charAt(answer.length()-1)=='.')
                answer=answer.substring(0,answer.length()-1);
        }
        //5단계
        if(answer.length()==0)
            answer+='a';
        //6단계
        if(answer.length()>=16){
            answer=answer.substring(0,15);
            if(answer.charAt(answer.length()-1)=='.')
                answer=answer.substring(0,14);
        }
        //7단계
        if(answer.length()<=2){
            while(answer.length()<3){
                answer+=answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}
