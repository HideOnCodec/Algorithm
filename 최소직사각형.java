class Solution {
    
    public int solution(int[][] sizes) {
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){//가로보다 세로가 길면
                //명함을 회전시킨다.
                int tmp= sizes[i][1];
                sizes[i][1]=sizes[i][0];
                sizes[i][0]=tmp;
            }
        }
        int maxW=0,maxH=0;
        //가장 큰 가로길이과 세로길이를 찾음
        for(int i=0; i<sizes.length; i++){
            if(maxW<sizes[i][0])
                maxW=sizes[i][0];
            if(maxH<sizes[i][1])
                maxH=sizes[i][1];
        }
        int answer = maxW*maxH;//넓이
        return answer;
    }
}
