import java.util.*;

class Solution {
    static boolean isValid(int[] citations, int h){
        if(h <= citations[citations.length - h])
            return true;
        return false;
    }
    
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int h = 1; h <= citations.length; h++){
            if(isValid(citations, h))
                max = h;
        }
        
        return max;
    }
}

/**
h : H-Index
논문 n편 중 h번 이상 인용 : h개 이상, 나머지 : h번 이하 인 h의 최댓값

citations 오름차순 정렬
[i, i+1, ..., i+7]
index번째의 인용된 논문의 개수 : citations.length - (index - 1)

주의 : h의 범위를 먼저 세우고, h에 따라 탐색해야함. citations[i]를 기준으로 탐색하면 안됨
*/