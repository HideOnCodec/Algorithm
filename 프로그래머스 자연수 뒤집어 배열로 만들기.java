import java.util.*;
class Solution {
    public int[] solution(long n) {
        char[] arr =  String.valueOf(n).toCharArray();
        int[] result = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            result[arr.length-1-i] = arr[i]-'0';
        }
        return result;
    }
}
