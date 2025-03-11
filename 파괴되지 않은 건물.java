import java.util.*;

class Solution {
    static void prefixSum(int[][] board, int[][] sum){
        // 세로
        for(int y = 1; y < sum.length; y++){
            for(int x = 0; x < sum[0].length; x++){
                sum[y][x] += sum[y - 1][x];
            }
        }
        
        // 가로
        for(int x = 1; x < sum[0].length; x++){
            for(int y = 0; y < sum.length; y++){
                sum[y][x] += sum[y][x - 1];
            }
        }
    }
    
    static int countRemainedBuilding(int[][] board, int[][] sum){
        int cnt = 0;
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                if(board[y][x] + sum[y][x]> 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(int[][] board, int[][] skills) {
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        
        for(int[] skill : skills){
            int type = skill[0];
            int y1 = skill[1], y2 = skill[3];
            int x1 = skill[2], x2 = skill[4];
            int degree = skill[5] * (type == 1 ? -1 : 1);
            
            sum[y1][x1] += degree;
            sum[y2 + 1][x1] += degree * -1;
            sum[y1][x2 + 1] += degree * -1;
            sum[y2 + 1][x2 + 1] += degree;
        }
        
        prefixSum(board, sum);
        return countRemainedBuilding(board, sum);
    }
}

/**
1. 누적합 전용 board 생성 : sum[board.length + 1][ board.length + 1] 
2. 누적합 이용(y, x)
- (y1, x1) : degree
- (y2 + 1, x1) : -degree
- (y1, x2 + 1) : -degree
- (y2 + 1, x2 + 1) : degree
3. 마지막에 sum을 가로, 세로 한번씩 모두 합한 후 최종 board값과 더함
4. 파괴되지 않은 건물의 수 세기 
*/
