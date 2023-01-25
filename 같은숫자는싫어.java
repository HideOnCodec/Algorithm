import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(!stack.empty()){//스택이 비어있지 않으면
                if(stack.peek()!=arr[i])//이전 숫자와 다르면
                    stack.push(arr[i]);//스택에 push
            }
            else//스택에 아무것도 없으면
                stack.push(arr[i]);//그냥 바로 push
        }
        int answer[]=new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--)
            answer[i] = stack.pop();
		//스택은 pop하면 선입후출이므로 역순서로 배열에 넣는다.
        return answer;
    }
}
