import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<m+1; j++){
                int num = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+num;
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());


            System.out.println(sum[y2][x2] - sum[y1-1][x2] - sum[y2][x1-1]+sum[y1-1][x1-1]);
        }
        
    }
}
