import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder result = new StringBuilder();
        String[] arr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .toArray(String[]::new);

        for(String s : arr)
            result.append(s);
        String answer = result.toString(); 
        return answer.matches("0*") ? "0" : answer;
    }
}


