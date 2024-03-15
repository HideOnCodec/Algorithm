import java.io.*;
import java.util.*;

/* 
첫번째 방법 : Collection.sort() 이용하기
두번째 방법 : 배열을 안쓰면 훨씬 빠르게 이용가능 (즉시 비교)  
*/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int min=1000000, max = -1000000;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num<=min)
                min = num;
            if(num >= max)
                max = num;
        }
        sb.append(min+" "+max);
        System.out.println(sb);
    }
}
