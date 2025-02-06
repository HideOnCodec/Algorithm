import java.io.*;
import java.util.*;

public class Main {
    // dp[i] = i번째 수열의 최대 길이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        Map<Integer, Integer> dp = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            int prev = dp.getOrDefault(arr[i] - 1, 1);
            int next = dp.getOrDefault(arr[i] + 1, 1);
            int now = dp.getOrDefault(arr[i], 1);

            int max = Math.max(prev, next);
            if(now < max + 1){
                dp.put(arr[i], max + 1);
            }
            result = Math.max(result, max);
        }

        System.out.println(n - result);
    }
}
