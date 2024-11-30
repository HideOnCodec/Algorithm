import java.util.*;
/**
이진 탐색
개발언어, 직군, 경력, 소울푸드, 점수 
*/
class Solution {
    static Map<String, List<Integer>> scores = new HashMap<>();
    static String[] lan = {"cpp","java","python"};
    static String[] job = {"backend","frontend"};
    static String[] exp = {"junior","senior"};
    static String[] food = {"chicken","pizza"};
    
    static void createKey(String[] tokens, String result, int index){
        if(index == 4){
            if(!scores.containsKey(result))
                scores.put(result, new ArrayList<>());    
            scores.get(result).add(Integer.parseInt(tokens[4]));
            return;
        }
        
        createKey(tokens, result + tokens[index], index + 1);
        createKey(tokens, result + "-", index + 1);
    }
    
    static int binarySearch(String condition, int target){
        if(!scores.containsKey(condition))
            return 0;
        
        List<Integer> list = scores.get(condition);
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) >= target)
                right = mid;
            else
                left = mid + 1;
        }
        
        if(list.get(left) >= target)
            return list.size() - left;
        else
            return 0;
    }
    
    public int[] solution(String[] info, String[] query) {
        for(String str : info){
            String tokens[] = str.split(" ");
            createKey(tokens, "", 0);
        }
        
        for(List<Integer> list : scores.values()){
            Collections.sort(list);
        }
        
        int result[] = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String tokens[] = query[i].split(" ");
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < tokens.length - 1; j++){
                if(!tokens[j].equals("and")){
                    sb.append(tokens[j]);
                }
            }
            
            int target = Integer.parseInt(tokens[tokens.length - 1]);
            result[i] = binarySearch(sb.toString(), target);
        }
        
        return result;
    }
}
