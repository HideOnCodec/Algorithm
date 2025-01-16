import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] ar5gs) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int good = 0;
        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;
            long target = arr[i];

            while(left < right){
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right];
                if(sum == target){
                    good++;
                    break;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        System.out.println(good);
    }
}