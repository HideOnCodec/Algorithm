/**
카펫 가로 : x
카펫 세로 : y
카펫 테두리 : 2x+2(y-2) == brown, x+y-2 = brown/2
카펫 중앙 : (x-2)*(y-2) = yellow
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {1,1};
        for(int x=1; x<brown/2+2; x++){
            for(int y=1; y<=x; y++){
                if(x+y-2 == brown/2 && (x-2)*(y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                } 
            }
        }
        return answer;
    }
}