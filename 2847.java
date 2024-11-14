import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int score[] = new int[n];
        
        for(int i=0; i<n; i++)
            score[i]=Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(0);
            return;
        }

        int answer = 0;
        for(int i=score.length-1; i>=1; i--){
            if(score[i-1]>=score[i]){
                answer += score[i-1]-(score[i]-1);
                score[i-1]=score[i]-1;
            }
        }
        System.out.println(answer);
    }
    
}
