import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> kind = new HashMap<>();
        for(String gem : gems){
            kind.put(gem, 0);
        }
        
        int start = 0, end = gems.length - 1;
        int s = 0, e = 0;
        int cnt = 0;
        // 첫 보석 추가
        kind.put(gems[s], 1);
        cnt++;
        // 투포인터 탐색
        while(s < gems.length - 1){
            if(cnt == kind.size()){ // 모든 종류의 보석을 포함하면
                if(e - s < end - start){
                    start = s;
                    end = e;
                }
                
                int num = kind.get(gems[s]);
                kind.put(gems[s], num - 1);
                if(num - 1 == 0){
                    cnt--;       
                }
                s++;
            }
            else if(e < gems.length - 1){
                e++;
                int num = kind.get(gems[e]);
                kind.put(gems[e], num + 1);
                if(num == 0){
                    cnt++;
                }
            }
            else{
                break;
            }
        }
        
        int[] answer = {start + 1, end + 1};
        return answer;
    }
}

/**
3
1
s 0
e 0
AA 1 AB 0 AC 0 
*/
