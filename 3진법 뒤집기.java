import java.util.*;
/**
10진수 n -> 3진법으로 변환 -> reverse() -> 다시 10진법으로 보여주기
*/
class Solution {
    public int solution(int n) {
        String s = Integer.toString(n,3);
        s = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(s,3);
    }
}
    