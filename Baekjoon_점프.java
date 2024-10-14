import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++)
                board[i][j]=Integer.parseInt(st.nextToken());
        }

        long dp[][] = new long[n][n];
        // 초기값
        dp[0][0]=1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==n-1&&j==n-1 || board[i][j]==0) continue;
                if(dp[i][j]>0){
                    int nextY = i+board[i][j];
                    int nextX = j+board[i][j];
                    if(nextY<n) dp[nextY][j]+=dp[i][j];
                    if(nextX<n) dp[i][nextX]+=dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
        
    }
}
