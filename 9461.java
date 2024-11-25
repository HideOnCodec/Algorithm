import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;
        dp[5] = 2L;
        for(int i = 6; i <= 100; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}

/*
 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2
dp[6] = dp[5] + dp[1] = 2 + 1 = 3
dp[7] = dp[6] + dp[2] = 3 + 1 = 4
dp[8] = dp[7] + dp[3] = 4 + 1 = 5
dp[9] = dp[8] + dp[4] = 5 + 2 = 7
 */