import java.util.*;
/**
그리디 알고리즘 이용
한쪽의 합이 크면 큐에서 빼고 push하는 과정을 반복함
*/

// 포인터를 이용한 방법 
class Solution {    
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int cnt = 0;
        long sum1=Arrays.stream(queue1).sum();
        long sum2=Arrays.stream(queue2).sum();
        if((sum1+sum2)%2!=0){
            return -1;
        }
        long target = (sum1+sum2)/2;
        int merged[] = new int[len*2];
        
        for(int i=0; i<len; i++){
            merged[i]=queue1[i];
            merged[i+queue1.length]=queue2[i];
        }
        
        int start1=0;
        int end1=len-1;
        int start2=end1+1;
        int end2=len*2-1;
        
        while (cnt<=len*4) {
            if (sum1 == target) {
                return cnt;
            }
            
            if (sum1 > sum2) {
                int n = merged[start1];
                start1=(start1+1)%(len*2);
                end2=(end2+1)%(len*2);
                sum1 -= n;
                sum2 += n;
                
            } else {
                int n = merged[start2];
                start2=(start2+1)%(len*2);
                end1=(end1+1)%(len*2);
                sum2 -= n;
                sum1 += n;
            }
            
            cnt++;
        }
        return -1;
    }
}

// 큐 라이브러리 이용
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0; 
        long sum2= 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long target = (sum1 + sum2) / 2;
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        int cnt = 0;
        int maxOps = queue1.length * 4; 
        
        while (cnt <= maxOps) {
            if (sum1 == target) {
                return cnt;
            }
            
            if (sum1 > sum2) {
                int n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.offer(n);
            } else {
                int n = q2.poll();
                sum2 -= n;
                sum1 += n;
                q1.offer(n);
            }
            
            cnt++;
        }
        
        return -1; 
    }
}
