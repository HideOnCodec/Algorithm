import java.io.*;
import java.util.*;

/* 백준 10870번 피보나치 수 5 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        if(n == 0 || n == 1){
            System.out.println(n);
            return;
        }

        int n1 = 0;
        int n2 = 1;
        int result = 0;
        for(int i=2; i<=n; i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }

        System.out.println(result);
    }
}
