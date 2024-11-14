import java.io.*;
import java.util.*;

public class Main{
    static final int INT_MAX = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1];
        Arrays.fill(dp,INT_MAX);
        dp[0]=0; // 0원은 0개로 만들 수 있음
        
        for(int i=1; i<=n; i++){
            if(i>=2) dp[i]=Math.min(dp[i],dp[i-2]+1);
            if(i>=5) dp[i]=Math.min(dp[i],dp[i-5]+1);
        }

        System.out.println(dp[n] == INT_MAX ? -1 : dp[n]);
    }
    
}
