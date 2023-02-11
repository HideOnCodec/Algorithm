import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int min(int past,int arr[]){
        int min = 1000;
        int index=-1;
        for(int i=0; i<3; i++){
            if(min>arr[i]&&i!=past) {
                index = i;
                min = arr[i];
            }
        }
        return index;
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         int color[][]=new int[n][3];
         int house[] = new int[n];

         int min=1000;
         for(int i=0; i<n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine()," ");
             color[i][0]=Integer.parseInt(st.nextToken());
             color[i][1]=Integer.parseInt(st.nextToken());
             color[i][2]=Integer.parseInt(st.nextToken());
         }
         house[0]=min(-1,color[0]);
         for(int i=1; i<n; i++){
             house[i]=min(house[i-1],color[i]);
         }
         int sum=0;
         for(int i=0; i<n; i++){
             sum+=color[i][house[i]];
         }
         for(int i=0; i<n; i++)
             System.out.println(house[i]);
         System.out.println(sum);
    }
}
