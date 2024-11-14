import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int dp[];
    static int stair[];
    static int sum(int n){
        if(dp[n]==-1){
            dp[n]=Math.max(sum(n-2),sum(n-3)+stair[n-1])+stair[n];
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stair=new int[n+1];
        for(int i=1; i<n+1; i++){
            stair[i]=sc.nextInt();
        }

        dp=new int[n+1];
        for(int i=0; i<n+1; i++)
            dp[i]=-1;

        dp[0]=0;
        dp[1]=stair[1];
        if(n==1){
            System.out.println(dp[n]);
            return;
        }
        dp[2]=stair[1]+stair[2];

        System.out.println(sum(n));
    }
}
