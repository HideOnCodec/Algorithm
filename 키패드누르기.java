import java.util.*;
class Solution {
    int distance(int handPosition,int num){
        HashMap<Integer,int[]> keypad= new HashMap<>();
        int i=0,j=0;
        //keypad 번호의 위치 순서대로 넣기 예) 4번 -> {2,1}
        for(int n=1; n<=9; n++){
            if(n%3==1){
                j=1;
                i++;
            }  
            int[] value = {i,j};
            keypad.put(n,value);
            j++;
        }
        int value[][] = {{4,1},{4,2},{4,3}};//* 0 # 위치 넣기
        keypad.put(-1,value[0]);//*
        keypad.put(0,value[1]);//0
        keypad.put(-2,value[2]);//#
        /*
        누르는 번호와 현재 손가락의 거리 =
        세로 index 차이 + 가로 index 차이
        */
        int column=Math.abs(keypad.get(handPosition)[0]-keypad.get(num)[0]);
        int row = Math.abs(keypad.get(handPosition)[1]-keypad.get(num)[1]);
        
        return row+column;
    }
    
    public String solution(int[] numbers, String hand) {
        int L=-1, R=-2;//시작위치 * #
        String answer = "";
        Solution st = new Solution();
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){ //1,4,7 왼손
                L=numbers[i];
                answer+="L";
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){//3,6,9 오른손
                R=numbers[i];
                answer+="R";
            }
            else{ //2, 5, 8, 0이면 왼손과 오른손의 거리 비교
                //왼손이 더 멀면
                if(st.distance(L,numbers[i])>st.distance(R,numbers[i]))  {
                    R=numbers[i];
                    answer+="R"; //오른손
                }
                else if(st.distance(L,numbers[i])<st.distance(R,numbers[i])){
                    //오른손이 더 멀면 왼손
                    L=numbers[i];
                    answer+="L";
                }
                else{//왼손과 오른손의 거리가 같으면 왼손잡이,오른손잡이인지 판단
                    if(hand.compareTo("right")==0){
                        R=numbers[i];
                        answer+="R";
                    }
                    else{
                        L=numbers[i];
                        answer+="L";
                    }
                }
                    
            }
        }
        return answer;
    }
}
