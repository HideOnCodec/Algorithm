import java.util.*;
import java.io.*;

public class Main {
    static long min = 1000000001;
    static long max = -1000000001; 
    static int n;
    public static void search(int[] operator,int[] arr, int index, long sum){
        if(index==n){
            if(sum < min)
                min = sum;
            if(sum > max)
                max = sum;
            return;
        }
        else{
            for(int i=0; i<4; i++){
                long sum2 = sum;
                int operator2[] = operator.clone();
                if(operator2[i]>0){
                    if(i==0) sum2 += arr[index];
                    if(i==1) sum2 -= arr[index];
                    if(i==2) sum2 *= arr[index];
                    if(i==3) sum2 /= arr[index];
                    operator2[i]--;

                    search(operator2,arr,index+1,sum2);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int arr[]=new int[n];
            int operator[] = new int[4]; // +, -, *, /
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<4; i++){
                operator[i]= Integer.parseInt(st.nextToken());
            }
            
            search(operator,arr,1,arr[0]);

            System.out.println(max);
            System.out.println(min);
    }

}

