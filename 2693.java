import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            for(int j=0; j<10; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(list,Comparator.reverseOrder());
            sb.append(list.get(2));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
