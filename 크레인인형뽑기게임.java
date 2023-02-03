import java.util.*;
class Solution {
    
    public int solution(int[][] board, int[] moves) {
    	//바구니를 stack으로 구현
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        
        for(int i=0; i<moves.length; i++){
            int j=0;
           while(j<board.length){
               if(board[j][moves[i]-1]!=0){//보드판의 맨 위에 인형이 있으면 뽑기
                    if(!basket.empty()&&
                    (basket.peek()==board[j][moves[i]-1])){//바구니의 맨 위 인형이랑 뽑은 인형이 같으면
                        basket.pop();//바구니의 맨 위 인형 삭제
                        board[j][moves[i]-1]=0;
                        answer+=2;
                        break;
                    }//바구니 맨 위 인형이랑 뽑은 인형이 다르면  
                    basket.push(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
               j++;
            }
        }
        return answer;
    }
}
