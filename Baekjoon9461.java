import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long arr[]=new long[101];
    static long cal(int N){
        if(arr[N]==-1){
            arr[N]=cal(N-2)+cal(N-3);
        }
        return arr[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr[0]=1;
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        arr[4]=2;
        arr[5]=2;
        for(int i=6; i<arr.length; i++)
            arr[i]=-1;
        for(int i=0; i<T; i++) {
            int N=Integer.parseInt(br.readLine());
            System.out.println(cal(N));
        }
    }
}
