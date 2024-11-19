import java.util.*;

class Solution {  
    static long cal(long num1, long num2, String operator){
        return switch(operator){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> 0;
        };
    }
    
    static long search(String[] precedure, List<String> expList){
        for(String operator : precedure){
            for(int i = 0; i<expList.size(); i++){
                if(expList.get(i).equals(operator)){
                    long num1 = Long.parseLong(expList.get(i-1));
                    long num2 = Long.parseLong(expList.get(i+1));
                    long result = cal(num1, num2, expList.get(i));
                    expList.remove(i-1);
                    expList.remove(i-1);
                    expList.remove(i-1);
                    expList.add(i-1, String.valueOf(result));
                    i -= 1;
                }
            }
        }
        return Math.abs(Long.parseLong(expList.get(0)));
    }
    
    public long solution(String expression) {
        String[][] precedures = {
            "+-*".split(""),
            "+*-".split(""),
            "*-+".split(""),
            "*+-".split(""),
            "-+*".split(""),
            "-*+".split("")
        };
        
        // 수식 리스트 생성
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        
        // 우선순위별 탐색
        long max = 0;
        for(String[] precedure : precedures){
            long result = search(precedure, new ArrayList<>(tokens));
            if(max < result) max = result; 
        }
        
        return max;
    }
}