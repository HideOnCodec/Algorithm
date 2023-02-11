import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         int dp[][]=new int[n][3];
         
         for(int i=0; i<n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine()," ");
             int R=Integer.parseInt(st.nextToken());
             int G=Integer.parseInt(st.nextToken());
             int B=Integer.parseInt(st.nextToken());
             
             if(i==0) {
            	 dp[0][0]=R;
            	 dp[0][1]=G;
            	 dp[0][2]=B;
             }
             else {
            	 dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+R;//빨간색일 경우
            	 dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+G;//초록색일 경우
            	 dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+B;//파란색일 경우
             }
         }
         
         int min=dp[n-1][0];
         for(int i=1; i<3; i++) {
        	 if(min>dp[n-1][i])
        		 min=dp[n-1][i];
         }
         
         System.out.println(min);
    }
}

/* 처음 틀렸을 때 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int min(int past,int arr[]){
        int min = 1000;
        int index=-1;
        for(int i=0; i<3; i++){
            if(min>arr[i]&&i!=past) {
                index = i;
                min = arr[i];
            }
        }
        return index;
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         int color[][]=new int[n][3];
         int house[] = new int[n];

         int min=1000;
         for(int i=0; i<n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine()," ");
             color[i][0]=Integer.parseInt(st.nextToken());
             color[i][1]=Integer.parseInt(st.nextToken());
             color[i][2]=Integer.parseInt(st.nextToken());
         }
         house[0]=min(-1,color[0]);
         for(int i=1; i<n; i++){
             house[i]=min(house[i-1],color[i]);
         }
         int sum=0;
         for(int i=0; i<n; i++){
             sum+=color[i][house[i]];
         }
         for(int i=0; i<n; i++)
             System.out.println(house[i]);
         System.out.println(sum);
    }
}
*/
