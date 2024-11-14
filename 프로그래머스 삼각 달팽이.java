class Solution {
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        // 아래, 오른쪽, 왼쪽 위 
        int dx[]={0,1,-1}; 
        int dy[]={1,0,-1};
        int x=0, y=0;
        int triangle[][] = new int[n][n];
        int num = 1;
        
        int d = 0;
        while(num<=max){
            triangle[y][x]=num;
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if(ny<0||ny>=n||nx<0||nx>=n||triangle[ny][nx]!=0){
                d=(d+1)%3;
                x += dx[d];
                y += dy[d];
            }
            else{
                x = nx;
                y = ny; 
            }
            num++;
        }
        
        int result[] = new int[max];
        int index=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(triangle[i][j]!=0)
                    result[index++]=triangle[i][j];
            }
        }
        
        return result;
    }
}
