/**
 * 백준 15486번 퇴사 2
 * dp 문제
 * dp[i] : i번째부터 마지막날까지의 최대 수익 (이 부분을 정확히 정하고 푸는 것이 중요하다)
 * dp[i] = Math.max(dp[i+1],dp[i+t[i]])
 * 마지막 날까지 상담을 끝낼 수 있다면 점화식을 고려함.
 * 현재 날짜의 상담을 선택할 경우 : 상담할 시의 금액 + 현재 날짜부터 상담 기간이 지나고 그 다음 날부터 ~ 마지막날까지의 최대 수익(dp[i+t[i]]) 
 * 현재 날짜의 상담을 안할 경우 : 현재 날짜 제외하고 그 다음날부터 ~ 마지막날까지의 최대 수익(dp[i+1])
 */

 import java.util.*;
 import java.io.*;
 import java.awt.*;


 public class Main { 
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t[] = new int[n+1];
        int p[] = new int[n+1];
        int dp[] = new int[n+1];
        
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            t[i] = Integer.parseInt(st.nextToken()); // 걸리는 기간
            p[i] = Integer.parseInt(st.nextToken()); // 금액 
            dp[i] = 0;
        }

        if(t[n]==1) dp[n]=p[n]; // dp[n] 초기값
        else dp[n]=0;

        for(int i=n-1; i>=1; i--){
            if(i+t[i]-1<=n){ // 마지막 날까지 상담을 끝낼 수 있으면
                if(i+t[i]>n) dp[i] = Math.max(dp[i+1],p[i]);
                else dp[i] = Math.max(dp[i+1],p[i]+dp[i+t[i]]); // i번째 상담을 안할 경우 or 할 경우
            }
            else dp[i]=dp[i+1]; // 마지막 날까지 상담을 못 끝내면 어차피 제외해야함 
        }

        System.out.println(dp[1]); // 1일부터 마지막날까지 고려했을 때 최대 수익 
     }
 }
 
