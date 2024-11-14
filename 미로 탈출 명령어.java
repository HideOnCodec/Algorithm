import java.util.*;
import java.awt.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dx[]={1,-1,0,0};
        int dy[]={0,0,-1,1}; // 상 하 좌 우
        char d[] = {'d','u','l','r'};
        
        String visited[][] = new String[n+1][m+1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y]="";
        
        String min = "";
        boolean flag = false;
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            String nowS = visited[now.x][now.y];
            if(now.x==r&&now.y==c&&nowS.length()==k){
                flag=true;
                if(min.equals("")) min = nowS;
                else if(min.compareTo(nowS)>0) min = nowS;
            }
            
            if(nowS.length()<k){
                for(int i=0; i<4; i++){
                    int newX = now.x+dx[i];
                    int newY = now.y+dy[i];
                    String newS = nowS+d[i];
                    if(1<=newX&&newX<=n && 1<=newY&&newY<=m){
                        String isVisit = visited[newX][newY];
                        if(isVisit==null||isVisit.length()!=newS.length()||
                          (isVisit.length()==newS.length()&&isVisit.compareTo(newS)>0)){
                                queue.add(new Point(newX,newY));
                                visited[newX][newY]=newS;
                        }
                    }
                }
            }
        }
        return flag ? min : "impossible";
    }
}
