import java.util.*;
import java.io.*;

public class Main {

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    int arr[] = new int[1001];
    arr[0]=0;
    int index=1;
    for(int i=1; i<1000; i++){
        for(int j=0; j<i; j++){
                arr[index]=arr[index-1]+i;
                if(index==b){
                    System.out.println(arr[b]-arr[a-1]);
                    return;
                }
                index++;
            }
        }
    }

}

