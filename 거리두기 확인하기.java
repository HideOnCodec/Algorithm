import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static final int dx[] = {0,0,-1,1};
    static final int dy[] = {-1,1,0,0};
    
    static int isDistanced(char[][] room){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(room[i][j]=='P'){
                    for(int d=0; d<4; d++){
                        int nx = j + dx[d];
                        int ny = i + dy[d];
                        if(ny<0 || ny>=5 || nx<0 || nx>=5) continue;
                        if(room[ny][nx]=='P')
                            return 0;
                        else if(room[ny][nx]=='O' && !isDistanced(room,j,i,nx,ny)){
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
    // 맨해튼 거리 2번째 방 탐색을 위함
    static boolean isDistanced(char[][] room, int x, int y, int nx, int ny){
        for(int i=0; i<4; i++){
            int nnx = nx + dx[i];
            int nny = ny + dy[i];
            if((nnx==x && nny==y) || (nny<0 || nny>=5 || nnx<0 || nnx>=5)) 
                continue;
            if(room[nny][nnx]=='P')
                return false;
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        
        for(int i=0; i<5; i++){
            // 방 배열 생성
            char[][] room = new char[5][5];
            for(int j=0; j<5; j++)
                room[j] = places[i][j].toCharArray();
            // 거리 두기 여부 
            result[i] = isDistanced(room);
        }
        
        return result;
    }
}
