import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int matrixA[][] = new int[n][m];
        int matrixB[][] = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                matrixA[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                matrixB[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int result[][]=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[i][j]=matrixA[i][j]+matrixB[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
