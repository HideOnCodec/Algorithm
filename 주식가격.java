import java.util.*;
class Solution {
	public int[] solution(int[] prices) {
		Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                result[stack.peek()] += i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            result[i] = prices.length - 1 - i;
        }
        
        return result;
	}
}