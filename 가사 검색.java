import java.util.*;

class Solution {
       static int searchCount(String target, List<String> list) {
    int left = 0;
    int right = list.size() - 1;
    int min = Integer.MAX_VALUE; // 초기값을 최대값으로 설정

    while (left <= right) {
        int mid = (left + right) / 2;
        String word = list.get(mid);

        if (word.compareTo(target) >= 0) {
            min = Math.min(min, mid); // 최솟값 갱신
            right = mid - 1; // 왼쪽 범위를 탐색
        } else {
            left = mid + 1; // 오른쪽 범위를 탐색
        }
    }

    return min == Integer.MAX_VALUE ? list.size() : min; // 최솟값이 갱신되지 않았다면 리스트 크기를 반환
}
 
    
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> frontMap = new HashMap<>();
        Map<Integer, List<String>> backMap = new HashMap<>();
        
        for(String word : words){
            int len = word.length();
            if(!frontMap.containsKey(len)){
                frontMap.put(len, new ArrayList<>());
                backMap.put(len, new ArrayList<>());
            }
            frontMap.get(len).add(word);
            backMap.get(len).add(new StringBuilder(word).reverse().toString());
        }
        
        for(List<String> list : frontMap.values()){
            Collections.sort(list);
        }
        for(List<String> list : backMap.values()){
            Collections.sort(list);
        }
        
        int[] result = new int[queries.length];
        for(int i = 0; i < result.length; i++){
            String query = queries[i];
            int len = queries[i].length();
            List<String> list;
            if(!frontMap.containsKey(len)){
                result[i] = 0;
                continue;
            }
            
            if(query.charAt(0) == '?'){
                list = backMap.get(len);
                query = new StringBuilder(query).reverse().toString();
            }
            else{
                list = frontMap.get(len);
            }
            
            int min = searchCount(query.replace("?",""), list);
            int max = searchCount(query.replace('?',Character.MAX_VALUE), list);
            result[i] = max - min;
        }
        return result;
    }
}

