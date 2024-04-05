import java.io.*;
import java.util.*;

/* 백준 2309번 일곱 난쟁이 

7명 난쟁이 키의 합(100) + 2명 가짜 난쟁이 키의 합 = 전체 난쟁이의 합
-> 전체 난쟁이 키의 합 - 2명 가짜 난쟁이 키의 합 = 100

7명 난쟁이 조합을 찾아서 100이 되는지 확인하는 것이 아니라
2명 난쟁이 조합을 찾아서 전체 키의 합에서 2명의 키를 뺀 값이 100인지를 확인함

역으로 생각할 것!
*/

public class Main {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> height = new ArrayList<>();
        int sum=0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            height.add(num);
            sum+=num;
        }
        
        
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum-(height.get(i)+height.get(j)) == 100 ){
                    height.remove(i);
                    height.remove(j-1);
                    Collections.sort(height);
                    for(int c=0; c<7; c++){
                        System.out.println(height.get(c));
                    }
                    return;
                }
            }
        }

    }
}
