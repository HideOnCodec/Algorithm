import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int count[]=new int[10];
        for(int i=0; i<numbers.length; i++){
            count[numbers[i]]++;
    }
        int sum=0;
        for(int i=0; i<10; i++){
            if(count[i]==0)
                sum+=i;
        }
        return sum;
    }
}