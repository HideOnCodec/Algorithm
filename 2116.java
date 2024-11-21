import java.io.*;
import java.util.*;

/* 백준 2116번 주사위 쌓기 */
public class Main{
    static int n;
    static int[][] dices;

    static int sideMax(int[][] state){
        int sum = 0;
        for(int dice = 0; dice < n; dice ++){
            int max = 0;
            for(int i = 0; i < 6; i++){
                if(i != state[dice][0] && i != state[dice][1]){ // 윗면, 아랫면이 아닌 옆면일때만 계산
                    max = Math.max(max, dices[dice][i]);
                }
            }
            sum += max;
        }
        return sum;
    }

    static void setDices(int[][] state, int[] opposite){
        int bottom = dices[0][state[0][1]];
        for(int dice = 1; dice < n; dice++){
            for(int i = 0; i < 6; i++){
                if(dices[dice][i] == bottom){ // 아랫면과 숫자가 같으면
                    state[dice][0] = i; // 아랫면 인덱스
                    state[dice][1] = opposite[i]; // 윗면 인덱스
                    bottom = dices[dice][state[dice][1]]; // 현재 윗면이 위의 주사위의 아랫면이 됨 
                    break;
                }
            } 
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dices = new int[n][6];
        int state[][] = new int[n][2]; // 주사위별 0: 아랫면, 1: 윗면 인덱스 저장 

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 6; j++)
                dices[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] opposite = {5, 3, 4, 1, 2, 0};

        int max = 0;
        for(int face = 0; face < 6; face++){
            state[0][0] = opposite[face]; // 1번 주사위 아랫면, 윗면 설정
            state[0][1] = face;
            setDices(state, opposite);
            max = Math.max(max, sideMax(state));
        }
        System.out.println(max);

    }
}

/**
 6면 중 하나를 1번 주사위의 윗면으로 설정 (0 ~ 5)
 - 각 2번 ~ n번 주사위에서 윗면 아랫면 설정  ((n-1) * 6)
 - 1번 ~ n번 주사위의 옆면 중 가장 큰 값만 더하기 (6n)

 맞은편 관계 : A(0) - F(5), C(2) - E(4), B(1) - D(3)
 시간 복잡도 : O(n)
 */
 

