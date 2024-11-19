import java.util.*;
/**
상태 : (str)
종료 조건 : sb.length() == 5 || sb 문자열이 word와 같을 때
점화식 : (str) = (str+A~U)
https://school.programmers.co.kr/learn/courses/30/lessons/84512
*/
class Solution {
    static int cnt = 0;
    static int result = 0;
    static void dfs(String word, StringBuilder str, char[] alphabets){
        if(str.toString().equals(word)){
            result = cnt;
            return;
        } 
        if(str.length()==5) return;
        for(char alphabet : alphabets){
            cnt++;
            dfs(word, str.append(alphabet), alphabets);
            str.delete(str.length()-1,str.length());
        }
    }
    
    public int solution(String word) {
        char[] alphabets = "AEIOU".toCharArray();
        dfs(word, new StringBuilder(), alphabets);
        return result;
    }
}

