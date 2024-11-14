import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[n+1][2];
        for(int i=1; i<=n; i++){
            arr[i][0]= sc.nextInt(); // weight
            arr[i][1]= sc.nextInt(); // value
        }
        // Max(dp[j-1][i-w[j]] + dp[j][i], dp[j-1][i])
        int dp[][] = new int[n+1][k+1];
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(arr[j][0]>i) // 담을 수 없으면
                {
                    dp[j][i]=dp[j-1][i];
                }
                else
                    dp[j][i]=Math.max(dp[j-1][i-arr[j][0]] + arr[j][1] , dp[j-1][i]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
