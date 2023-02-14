import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stair[]=new int[n];
        for(int i=0; i<n; i++){
            stair[i]=sc.nextInt();
        }

        int dp[]=new int[n];
        dp[0]=0;
        dp[1]=stair[0];
        dp[2]=stair[1];
        for(int i=3; i<n; i++){
            dp[i]= Math.max(dp[i-2],dp[i-3]+stair[i-1])+stair[i];
        }

        System.out.println(dp[n-1]);

    }
}
