// import java.util.*;
// /**
// 문자 하나씩 순회 
//     a. isDigit이 ture이면 그대로 추가
//     b. isDigit이 false이면 match에 맞는 숫자 찾은 후 추가
// */
// class Solution {      
//     public int solution(String s) {
//         Map<String,Integer> match = new HashMap<>();
//         StringBuilder result = new StringBuilder();
//         String[] word = {"zero","one","two","three","four",
//                          "five","six","seven","eight","nine"};
//         for(int i=0; i<=9; i++)
//             match.put(word[i],i);
        
//         char[] arr = s.toCharArray();
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<arr.length; i++){
//             if(Character.isAlphabetic(arr[i])){
//                 sb.append(arr[i]);
//                 String num = sb.toString();
//                 if(match.containsKey(num)){
//                     result.append(match.get(num));
//                     sb.setLength(0);
//                 }
//             }
//             else
//                 result.append(arr[i]); 
//         }
        
//         return Integer.parseInt(result.toString());
//     }
        
// }

import java.util.*;
/**
문자열에서 word에 해당하는 단어들 모두 치환
*/
class Solution {      
    public int solution(String s) {
        String[] words = {"zero","one","two","three","four",
                         "five","six","seven","eight","nine"};
        for(int i=0; i<words.length; i++){
            s = s.replace(words[i],String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
        
}