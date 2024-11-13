import java.io.*;
import java.util.*;

// 1 : 8 + 2(daldidan)
// 2 : 8 + 1 + 2(daldidan) == 11
// 3 : 8 + 1 + 2(daldidalgo daldian) == 11
// 4 : 8 + 1 + 1 + 2(daldidalgo daldian) == 12
// 5 : 8 + 1 + 1 + 2(daldidalgo daldidan) == 12
// 6 : 8 + 1 + 1 + 2(daldidalgo daldidan) == 12
public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        int index = n;
        while(index>1){
            index/=2;
            count++;
        }

        System.out.println(10+count);
    }
    
}
