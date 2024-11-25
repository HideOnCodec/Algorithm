import java.util.*;
/** 
0 ~ orders 
    String -> 길이 2 이상인 부분 집합 추가(map)
    재귀 이용 
*/
class Solution {
    static Map<String,Integer> combinations;
    static int max = 0;
    static void searchSet(int course, char[] arr, int index, StringBuilder menu){
        if(menu.length() == course){
            String courseMenu = menu.toString();
            int cnt = combinations.getOrDefault(courseMenu.toString(), 0);
            combinations.put(courseMenu.toString(), cnt + 1);
            max = Math.max(max, cnt + 1);
            return;
        }
        if(index == arr.length)
            return;
        
        // 현재 단품 메뉴 선택
        searchSet(course, arr, index + 1, menu.append(arr[index]));
        menu.delete(menu.length() - 1, menu.length());
    
        // 선택 안함
        searchSet(course, arr, index + 1, menu);
        
    }
    
    public String[] solution(String[] orders, int[] course) {   
        List<String> result = new ArrayList<>();
        
        for(int num : course){
            max = 0;
            combinations = new HashMap<>();
            // 조합 추가
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                searchSet(num, arr, 0, new StringBuilder());
            }
            // 가장 많이 주문된 조합
            for(String key : combinations.keySet()){
                int value = combinations.get(key);
                if(value >= 2 && value == max)
                    result.add(key);
            }   
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}