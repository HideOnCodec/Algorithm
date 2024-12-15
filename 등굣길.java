class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        // m 가로, n 세로
        int map[][] = new int[n + 1][m + 1];
        map[1][1] = 1;
        
        for(int[] water : puddles){
            map[water[1]][water[0]] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == -1 || map[i][j] == 0){
                    continue;
                }
                if(j + 1 <= m && map[i][j + 1] != -1){
                    map[i][j + 1] += map[i][j] % MOD;
                }
                if(i + 1 <= n && map[i + 1][j] != -1){
                    map[i + 1][j] += map[i][j] % MOD;
                }
            }
        }
        
        return map[n][m] % MOD;
    }
}