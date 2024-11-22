import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1]; 
        dp[1] = 1;
        for(int i = 1; i <= n; i++){
            if(dp[i] >= 1){
                if(i + 1 <= n) dp[i + 1] = dp[i] + 1;
                if(i + 3 <= n) dp[i + 3] = dp[i] + 1;
                if(i + 1 == n || i + 3 == n) break;
            }
        }

        // 홀수 번째 : 상근, 짝수 번째 : 찬영
        if(dp[n] % 2 == 0) 
            System.out.println("CY");
        else System.out.println("SK");
    }
}
