import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        long sum=0; // 결과
        long multiply=1; 

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c=='('){ //여는 괄호는 push 후 값 곱하기
                stack.push(c);
                multiply*=2; 
            }
            else if(c=='['){
                stack.push(c);
                multiply*=3;
            }
            else if(c==')'){ // 닫힌 괄호는 pop
                if(stack.isEmpty()||stack.peek()!='('){ // 스택이 비어있거나 괄호쌍이 아니면 0
                    sum=0;
                    break;
                }
                if(input.charAt(i-1)=='('){
                    sum+=multiply; // 바깥부터 가장 안쪽까지 곱하고 최종 값을 더함
                }
                stack.pop();
                multiply/=2; // 안쪽부터 바깥까지 다시 차례대로 닫힌 괄호가 나오면서 multiply를 되돌리기
            }
            else if(c==']'){
                if(stack.isEmpty()||stack.peek()!='['){ // 스택이 비어있거나 괄호쌍이 아니면 0
                    sum=0;
                    break;
                }
                if(input.charAt(i-1)=='['){
                    sum+=multiply;
                }
                stack.pop();
                multiply/=3;
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(sum);
        }
    }
}

