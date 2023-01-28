import java.util.*;
class Solution {
    public int solution(String s) {
        String word[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        HashMap<String,Integer> numWord = new HashMap<>();
        for(int i=0; i<10; i++)
            numWord.put(word[i],i);
        
        for(int i=0; i<10; i++){
                s=s.replace(word[i],String.valueOf(numWord.get(word[i])));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
