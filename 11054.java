// 틀린 코드
import java.util.Scanner;

public class Main {
    static int arr[];
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr=new int[n];
        dp=new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            dp[i]=1;
        }

        for(int i=0; i<n; i++){
            int tmp1=0;
            int tmp2=0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1)
                    tmp1=dp[j];
            }

            for(int c=n-1; c>=i+1; c--){
                if(arr[i]>arr[c] && dp[i]<dp[c]+1)
                    tmp2=dp[c];
            }
            dp[i]=tmp1+tmp2+1;
        }
        int max=0;
        for(int i=0; i<n; i++){
            if(max<dp[i])
                max=dp[i];
        }

        System.out.println(max);
    }
}

// 맞은 코드
import java.util.Scanner;

public class Main {
    static int arr[];
    static int dp1[];
    static int dp2[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr=new int[n];
        dp1=new int[n];
        dp2=new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            dp1[i]=1;
            dp2[i]=1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp1[i]<dp1[j]+1)
                    dp1[i]=dp1[j]+1;
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(arr[i]>arr[j] && dp2[i]<dp2[j]+1)
                    dp2[i]=dp2[j]+1;
            }
        }
        int max=0;
        for(int i=0; i<n; i++){
            if(max<dp1[i]+dp2[i])
                max=dp1[i]+dp2[i];
        }

        System.out.println(max-1);
    }
}
