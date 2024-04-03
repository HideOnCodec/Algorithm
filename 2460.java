import java.io.*;
import java.util.*;

// 백준 2460번 지능형 기차 2 

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max=-1;
        int people = 0;

        for(int i=0; i<10; i++){
            String num[] = br.readLine().split(" ");
            int out = Integer.parseInt(num[0]);
            int in = Integer.parseInt(num[1]);

            people = people - out + in;
            if(people > max)
                max = people; 
        }

        System.out.println(max);
    }
}
