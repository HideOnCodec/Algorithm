import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int dp[];
    static int wine[];
    static int N;
    static int grape(int n){
        if(dp[n]==-1){
            dp[n] = Math.max(Math.max(grape(n-2), grape(n-3) + wine[n - 1]) + wine[n],grape(n-1));
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        wine=new int[N+1];
        for(int i=1; i<N+1; i++){
            wine[i]=sc.nextInt();
        }

        dp=new int[N+1];
        for(int i=1; i<N+1; i++)
            dp[i]=-1;
        dp[1]=wine[1];
        if(N==1){
            System.out.println(dp[1]);
            return;
        }
        if(N>1){
            dp[2]=wine[1]+wine[2];
        }
        if(N==2){
            System.out.println(dp[2]);
            return;
        }

        System.out.println(grape(N));

    }
}
