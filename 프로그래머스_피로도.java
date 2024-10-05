import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    static int[][] bingo = new int[5][5];
    static int[][] hit = new int[5][5];
    static int[][] call = new int[5][5];

    static int check(int y, int x){
        int cnt = 0;
        int r = 0;
        int c = 0;
        int diagonalL = 0;
        int diagonalR = 0; 
        // 가로
        for(int i=0; i<5; i++){
            if(hit[y][i]==1)
                r++;
        }
        // 세로
        for(int i=0; i<5; i++){
            if(hit[i][x]==1)
                c++;
        }
        // 좌대각선 
        if(y==x){
            for(int i=0; i<5; i++){
                if(hit[i][i]==1)
                    diagonalL++;
            }
        }
        // 우대각선 
        if(y+x==4){
            for(int i=0; i<5; i++){
                if(hit[4-i][i]==1)
                    diagonalR++;
            }
        }
        if(r==5) cnt++;
        if(c==5) cnt++;
        if(diagonalL==5) cnt++;
        if(diagonalR==5) cnt++;

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<5; j++)
                bingo[i][j]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<5; j++)
                call[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                int flag=0;
                for(int a=0; a<5; a++){
                    for(int b=0; b<5; b++){
                        if(bingo[a][b]==call[i][j]){
                            hit[a][b]++;
                            cnt+=check(a,b);
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1) break;
                }
                if(cnt>=3){
                    System.out.println(5*i+j+1);
                    return;
                }
            }
        }

    }
}

