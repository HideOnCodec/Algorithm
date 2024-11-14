import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer> item = new HashMap<>();
        int total = 0;
        for(int i=0; i<want.length; i++){
            item.put(want[i],number[i]);
            total+=number[i];
        }
        int days = 0;
        for(int i=0; i<discount.length-total+1; i++){
            Map<String,Integer> map = new HashMap<>(item);
            int flag = 1;
            for(int j=0; j<10; j++){
                if(map.get(discount[i+j])==null)
                    continue;
                    
                int cnt = map.get(discount[i+j]);
                if(cnt==1)
                    map.remove(discount[i+j]);
                else
                    map.put(discount[i+j],cnt-1);
            }
            if(map.isEmpty())
                days++;
        }
        return days;
    }
}
