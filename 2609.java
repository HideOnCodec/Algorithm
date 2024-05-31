import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a,b);
        System.out.println(gcd);
        System.out.println((a*b)/gcd);
        
    }
}
