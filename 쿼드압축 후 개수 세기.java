/* 누적합 이용
 class Solution {
    static int[][] sum;
    static int zero = 0;
    static int one = 0;

    // 구간의 합을 계산하는 함수
    static boolean isSame(int x, int y, int x2, int y2){
        int totalSum = sum[y2][x2] - sum[y-1][x2] - sum[y2][x-1] + sum[y-1][x-1];
        return totalSum == (x2 - x + 1) * (y2 - y + 1) || totalSum == 0;
    }

    static void quadTree(int[][] arr, int x, int y, int x2, int y2){
        // 구간이 모두 같다면 종료
        if(isSame(x+1, y+1, x2+1, y2+1)){
            if(arr[y][x] == 1) one++;
            else zero++;
            return;
        }

        // 4분할 후 재귀 호출
        int midX = (x + x2) / 2;
        int midY = (y + y2) / 2;
        
        quadTree(arr, x, y, midX, midY); // 왼쪽 위
        quadTree(arr, midX + 1, y, x2, midY); // 오른쪽 위
        quadTree(arr, x, midY + 1, midX, y2); // 왼쪽 아래
        quadTree(arr, midX + 1, midY + 1, x2, y2); // 오른쪽 아래
    }

    public int[] solution(int[][] arr) {
        int n = arr.length;
        sum = new int[n + 1][n + 1];
        
        // 2D 누적합 배열 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = arr[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        quadTree(arr, 0, 0, n - 1, n - 1);
        return new int[]{zero, one};
    }
}
 */

 /** for문 이용
(y,x)          (y,x + size/2)
0       0       0       0 
0       0       0       0
(y+size/2,x)    (y+size/2,x+size/2)
0       0       0       0 
0       0       0       0
*/
class Solution {
    static int zero = 0;
    static int one = 0;

    static boolean isSame(int x, int y, int size, int[][] arr){
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(arr[y][x]!=arr[i][j]) // 2차원이므로 단순히 열의 이전과 비교하면 안됨!
                    return false;
            }
        }
        if(arr[y][x] == 1) one++;
        else zero++;
        return true;
    }
    
    static void recur(int x, int y, int size, int[][] arr){
        if(!isSame(x, y, size, arr)){
            recur(x, y, size/2, arr);
            recur(x + size/2, y, size/2, arr);
            recur(x, y + size/2, size/2, arr);
            recur(x + size/2, y + size/2, size/2, arr);
        }
    }
    
    public int[] solution(int[][] arr) {
        recur(0, 0, arr.length, arr);
        return new int[]{zero, one};
    }
}




