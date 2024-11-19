import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int visited[] = new int[7]; 
    
    static boolean isPrime(int n){
        if(n <= 1) return false;    // 0과 1은 소수가 아님
        if(n == 2) return true;     // 2는 소수
        if(n % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님

        // 3부터 n의 제곱근까지 홀수만 검사
        for(int i = 3; i * i <= n; i += 2){
            if(n % i == 0) return false; // 나누어 떨어지면 소수가 아님
        }
        return true;  // 나누어 떨어지지 않으면 소수
    }
    
    static void dfs(char[] arr){
        if(sb.length() > 0){
            int n = Integer.parseInt(sb.toString());
            if(isPrime(n))
                primes.add(n);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                sb.append(arr[i]);
                dfs(arr);
                visited[i] = 0;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
    
    public int solution(String numbers) {
        List<Integer> numList = new ArrayList<>();
        char[] arr = numbers.toCharArray();
        
        dfs(arr);
        return primes.size();
        
    }
}