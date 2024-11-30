import java.util.*;

class Solution {
    static String getDeadLine(String date, int term){
        String[] token = date.split("\\.");
        int year = Integer.parseInt(token[0]);
        int month = Integer.parseInt(token[1]);
        int day = Integer.parseInt(token[2]);
        
        year += term / 12;
        month += term % 12;
        if(month > 12){
            month -= 12;
            year += 1;
        }
        day -= 1;
        
        if(day == 0){
            day = 28;
            month -= 1;
            if(month == 0){
                month = 12;
                year -= 1;
            }
        }
        
        String result = year+".";
        if(1 <= month && month <= 9)
            result += "0"+month+".";
        else
            result += month + ".";
        if(1<=day && day<=9)
            result += "0"+day;
        else
            result += day;
        return result;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관별 유효기간 저장
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String token[] = term.split(" ");
            termMap.put(token[0], Integer.parseInt(token[1]));
        }
        
        List<Integer> result = new ArrayList<>();
        // 개인정보 유효 여부 판단
        for(int i = 0; i < privacies.length; i++){
            String token[] = privacies[i].split(" ");
            String deadLine = getDeadLine(token[0], termMap.get(token[1]));
            if(today.compareTo(deadLine) > 0)
                result.add(i + 1);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}

/**
2021년 12월 1일 16개월
16 / 12 = 1
2022년 12월 1일 
16 % 12 = 4
16월 -> 16 - 12 = 4
4월 1일
1일 -> 3월 28일
*/