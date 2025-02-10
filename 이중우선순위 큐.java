import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        int size = 0;
        for(String operation : operations){
            String[] op = operation.split(" ");
            int num = Integer.parseInt(op[1]);
            
            if(op[0].equals("I")){ // 삽입 연산
                max.offer(num);
                min.offer(num);
            }
            else if(num == 1 && !max.isEmpty()){ // 최댓값 삭제 연산
                min.remove(max.poll());
            }
            else if(num == -1 && !min.isEmpty()){ // 최솟값 삭제 연산
                max.remove(min.poll());
            }
        }
        
        if(!max.isEmpty()){
            return new int[]{max.peek(), min.peek()};
        }
        else{
            return new int[]{0,0};
        }
    }
}

/** 
 TreeMap 방법

 import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String operation : operations){
            String[] op = operation.split(" ");
            int num = Integer.parseInt(op[1]);
            
            if(op[0].equals("I")){ // 삽입 연산
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else if(num == 1 && !map.isEmpty()){ // 최댓값 삭제 연산
                int max = map.lastKey();
                map.put(max, map.get(max) - 1);
                if(map.get(max) <= 0){
                    map.remove(max);
                }
            }
            else if(num == -1 && !map.isEmpty()){ // 최솟값 삭제 연산
                int min = map.firstKey();
                map.put(min, map.get(min) - 1);
                if(map.get(min) <= 0){
                    map.remove(min);
                }
            }
        }
        
        if(map.isEmpty()){
            return new int[]{0,0};
        }
        else{
            return new int[]{map.lastKey(), map.firstKey()};
        }
        
    }
}
 */
