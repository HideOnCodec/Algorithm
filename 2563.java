import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //도화지 100*100칸 구현
        int paper[][] = new int[100][100]; //초기값 0
        for(int i=0; i<n; i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            for(int j=y; j<y+10; j++){ // row
                for(int r=x; r<x+10; r++){ // col
                    paper[j][r] =1;
                }
            }
        }
        int area=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(paper[i][j]==1)
                    area++;
            }
        }
        System.out.println(area);
    }
}
