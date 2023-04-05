import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        Stack<Character> stack = new Stack<>();
        int i=0;
        String result="";
        while(i<s.length()){
            char c = s.charAt(i);
            if(c=='<'){
                while(s.charAt(i)!='>'){
                    result+=s.charAt(i++);
                }
                result+=s.charAt(i++);
            }
            else if(('0'<=c&&c<='9')||('a'<=c&&c<='z')) {
                while (s.charAt(i)!=' '&&s.charAt(i)!='<') {
                    stack.push(s.charAt(i++));
                    if (i == s.length())
                        break;
                }
                int j = stack.size();
                while (j != 0) {
                    result += stack.pop();
                    j--;
                }
            }
            else{
                result+=c;
                i++;
            }
        }
        System.out.println(result);
    }
}
