import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int screen[]=new int[n];//스크린
       int basket[]=new int[m];//바구니
       int left=0,right=left+m-1;//바구니 위치 인덱스 표현

       int j = sc.nextInt();
       int distance=0; //거리
       for(int i=0; i<j; i++){
           int apple=sc.nextInt()-1;//사과 위치
           if(apple<left){
               int diff=left-apple; //사과와 바구니 거리차이
               distance+=diff;
               //바구니 왼쪽으로 이동
               left-=diff;
               right-=diff;
           }
           else if(apple>right){
               int diff=apple-right; //사과와 바구니 거리차이
               distance+=diff;
               //바구니 오른쪽으로 이동
               right+=diff;
               left+=diff;
           }
       }
       System.out.println(distance);
    }
}
