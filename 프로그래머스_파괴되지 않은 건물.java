class Solution {
    public int solution(int[][] board, int[][] skill) {
        int sum[][] = new int[board.length+1][board[0].length+1];
        
        for(int[] s : skill){
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int degree = s[0] == 1 ? -1*s[5] : s[5];
            
            sum[y1][x1]+=degree;
            sum[y2+1][x1]+=(-1)*degree;
            sum[y1][x2+1]+=(-1)*degree;
            sum[y2+1][x2+1]+=degree;
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                sum[i][j+1]+=sum[i][j];
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                sum[i+1][j]+=sum[i][j];
        }
        int cnt = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]+sum[i][j]>0) cnt++;
            }
        }
        
        return cnt;
    }
}
