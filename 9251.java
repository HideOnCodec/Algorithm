import java.util.Scanner;

public class Main {
    static Integer dp[][];
    static String str1;
    static String str2;
    public static int LCS(int i, int j){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]==null){
            if(str1.charAt(i)==str2.charAt(j))
                dp[i][j]=LCS(i-1,j-1)+1;
            else
                dp[i][j]=Math.max(LCS(i-1,j),LCS(i,j-1));
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str1 = sc.nextLine();
        str2 = sc.nextLine();

        dp=new Integer[str1.length()][str2.length()];

        System.out.println(LCS(str1.length()-1,str2.length()-1));
    }
}
