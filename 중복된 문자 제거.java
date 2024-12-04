import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        char[] arr = my_string.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            if(!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }
        return sb.toString();
    }
}