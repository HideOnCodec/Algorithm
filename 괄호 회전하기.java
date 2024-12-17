import java.util.*;

class Solution {
    static boolean isValid(Map<Character, Character> map, char[] arr, int start){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[(i + start) % arr.length];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty() || stack.peek() != map.get(c)){ 
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            if(isValid(map, arr, i)) result++;
        }
        
        return result;
    }
}

/**
stack 이용
1. x만큼 회전 : (i + x) % s 길이 O(len(s))
2. isValid() : O(len(s))
최대 1000000
*/