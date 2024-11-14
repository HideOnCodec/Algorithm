import java.util.Scanner;

public class Main {
    static int arr[];
    static int dp[];

    public static int seq(int n){
        if(dp[n]==-1){
            dp[n]=1;

            for(int i=0; i<n; i++){
                if(arr[n]>arr[i]){
                    dp[n]=Math.max(dp[n],seq(i)+1);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp = new int[n];
        for(int i=0; i<n; i++)
            dp[i]=-1;

        dp[0]=1;

        for(int i=0; i<n; i++){
            seq(i);
        }

        int max=0;
        for(int i=0; i<n; i++){
            if(max<dp[i])
                max=dp[i];
        }
        System.out.println(max);
    }
}
