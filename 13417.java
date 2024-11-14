import java.io.*;
import java.util.*;

public class Main{
    static String answer(String str){
        char[] cards = str.toCharArray();
        StringBuilder answer = new StringBuilder();
        answer.append(cards[0]);

        for(int i=1; i<cards.length; i++){
            if(answer.charAt(0)<cards[i])
                answer.append(cards[i]);
            else
                answer.insert(0,cards[i]);
        }
        return answer.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            br.readLine();
            String str = br.readLine().replaceAll(" ","");
            sb.append(answer(str)).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
    
}
