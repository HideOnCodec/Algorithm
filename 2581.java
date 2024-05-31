import java.util.*;
import java.io.*;

public class Main {

public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int prime[] = new int[10001];
        prime[1]=1; // 1이면 소수가 아님
        for(int i=2; i<=Math.sqrt(10000); i++){
            if(prime[i]!=1){
                for(int j=i*2; j<=10000; j+=i){
                    prime[j]=1;
                }
            }            
        }
        int sum=0;
        int min=0;
        Boolean flag=false;
        for(int i=m; i<=n; i++){
            if(prime[i]==0){
                flag=true;
                if(min==0) min=i;
                sum+=i;
            }
        }
        if(flag){
            System.out.println(sum);
            System.out.println(min);
        }
        else System.out.println(-1);

    }

}

