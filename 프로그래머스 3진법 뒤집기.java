import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int num = n;
        while(num>0){
            list.add(num%3);
            num/=3;
        }
        
        int sum = 0;
        int index=0;
        for(int i=list.size()-1; i>=0; i--){
            sum+=Math.pow(3,index++)*list.get(i);
        }
        
        return sum;
    }
}
    
