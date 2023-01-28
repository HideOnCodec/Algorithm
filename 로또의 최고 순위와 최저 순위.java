import java.util.*;
class Solution {
    int countLank(int same){ //순위 계산 함수
        switch (same){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        Solution st = new Solution();
        int same =0, zeroCount=0;
        for(int i=0; i<6; i++){
            if(lottos[i]==0){//로또번호가 0이면
                zeroCount++;//0의 개수를 증가시키고
                continue;//다음 반복으로 바로 넘어감
            }
            for(int j=0; j<6; j++){
                if(lottos[i]==win_nums[j])//로또번호가 당첨되면
                    same++; //당첨번호 개수를 늘림
            }
        }
        //최고순위 : 기존 당첨 개수 + 비어있던 0만큼 당첨됨
        int maxLank = st.countLank(same + zeroCount);
        //최저순위 : 기존 당첨 개수 + 비어있던 0이 아무것도 당첨되지 않음
        int minLank = st.countLank(same);
        int[] answer = {maxLank,minLank};
        return answer;
    }
}
