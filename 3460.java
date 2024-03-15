import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/* Integer.toBinaryString() 사용하기 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(n);

            for(int j=binary.length()-1; j>=0; j--){
                if(binary.charAt(j)=='1'){
                    sb.append(binary.length()-1-j + " ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
