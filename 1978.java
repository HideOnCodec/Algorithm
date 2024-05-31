import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int prime[] = new int[1001];
        prime[1]=1;
        for(int i=2; i<Math.sqrt(1001); i++){
            if(prime[i]!=1){
                for(int j=2*i; j<1001; j+=i){
                    prime[j]=1;
                }
            }
        }
        int cnt=0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            if(prime[Integer.parseInt(st.nextToken())]==0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
