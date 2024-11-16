class Solution {
    boolean solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int p = 0;
        int y = 0;
        for(char c : arr){
            if(c=='p') p++;
            if(c=='y') y++;
        }
        
        return p==y;
    }
}
