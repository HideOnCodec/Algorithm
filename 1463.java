import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int dp[];
    static int min(int n){
        if(dp[n]==-1){
            if(n%3==0&&n%2==0) { //2와 3으로 모두 나뉘어지면
                dp[n]=Math.min(Math.min(min(n/3),min(n/2)),min(n-1))+1;
            }
            else if(n%3==0){//3으로만 나뉘어지면
                dp[n]=Math.min(min(n/3),min(n-1))+1;
            }
            else if(n%2==0){
                dp[n]=Math.min(min(n/2),min(n-1))+1;
            }
            else{
                dp[n]=min(n-1)+1;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp=new int[n+1];

        for(int i=0; i<n+1; i++)
            dp[i]=-1;

        dp[1]=0;
        if(n==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2]=1;
        System.out.println(min(n));
    }
}
