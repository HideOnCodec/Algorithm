import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i]=1;
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr,(e1,e2)->{
            return e1[0]-e2[0];
        });

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j][1] < arr[i][1] && dp[i] < dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int max=0;
        for(int i=0; i<n; i++){
            if(max<dp[i])
                max=dp[i];
        }
        System.out.println(n-max);

    }
}
