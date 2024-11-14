
/**
1. x 모든 0 제거 : replaceAll
2. x 길이 -> 이진 수 변환 : Integer.toString(len,2)
3. x 1이 되면 종료
*/

class Solution {
    public int[] solution(String s) {
        String x = s;
        int cnt = 0;    
        int removed = 0;
        while(!x.equals("1")){
            int len = x.replaceAll("0","").length();
            removed += x.length()-len;
            x = Integer.toString(len,2);
            cnt++;
        }
        
        return new int[]{cnt,removed};
    }
}