import java.io.*;
import java.util.*;

class Cell {
    int score;
    boolean visited;

    public Cell(int score, boolean visited) {
        this.score = score;
        this.visited = visited;
    }
}

public class Main {
    static Map<Integer, List<Cell>> map = new HashMap<>();
    static int[][] horses = new int[4][2]; // 각 말들의 위치 저장 (0: 경로, 1: 경로에서의 위치)
    static int[] dice = new int[10]; // 주사위 입력
    static int max = 0; // 최대 점수값

    static void initMap() {
        map.put(0, new ArrayList<>());
        // 외곽 경로(0 ~ 20)
        for (int i = 0; i <= 20; i++) {
            map.get(0).add(new Cell(i * 2, false));
        }

        // 10번 경로(0 ~ 3)
        map.put(1, new ArrayList<>(Arrays.asList(
            new Cell(10, false), new Cell(13, false), 
            new Cell(16, false), new Cell(19, false)
        )));
        // 20번 경로(0 ~ 2)
        map.put(2, new ArrayList<>(Arrays.asList(
            new Cell(20, false), new Cell(22, false), 
            new Cell(24, false)
        )));
        // 30번 경로(0 ~ 3)
        map.put(3, new ArrayList<>(Arrays.asList(
            new Cell(30, false), new Cell(28, false), 
            new Cell(27, false), new Cell(26, false)
        )));
        // 25번 경로(0 ~ 3)
        map.put(4, new ArrayList<>(Arrays.asList(
            new Cell(25, false), new Cell(30, false),
            new Cell(35, false), new Cell(40, false)
        )));
    }

    static int[] move(int dice, int nowPath, int nowCell) { // {경로, 도착지}
        List<Cell> path = map.get(nowPath);
        int next = nowCell + dice;
    
        if (nowPath == 0) { // 외곽 경로
            if (next > 20) { // 외곽 경로를 벗어나면 도착
                return new int[] {-1, -1};
            }
            switch (next) { // 특정 위치에서 새로운 경로로 이동
                case 5  : return new int[] {1, 0};
                case 10 : return new int[] {2, 0};
                case 15 : return new int[] {3, 0};
                default : return new int[] {nowPath, next};
            }
        } else { // 10, 20, 30, 25 경로
            if (next >= path.size()) { // 현재 경로를 벗어나면 25번 경로로 이동하거나 도착
                if (nowPath == 1 || nowPath == 2 || nowPath == 3) {
                    int over = next - path.size(); // 남은 칸 계산
                    return new int[] { 4, over > map.get(4).size() - 1 ? -1 : over };
                } else { // 25번 경로를 벗어나면 도착
                    return new int[] { -1, -1 };
                }
            }
            return new int[] {nowPath, next};
        }
    }
    
    static void dfs(int turn, int score, int end) {
        if(turn == 10){ // 모든 주사위를 사용한 경우
            max = Math.max(max, score);
            return;
        }

        if(end == 4){
            return;
        }
        
        for(int i = 0; i < 4; i++){ // 4개의 말을 각각 시도
            int nowPath = horses[i][0];
            int nowCell = horses[i][1];
    
            if(nowPath == -1) continue; // 이미 도착한 말은 무시
    
            int[] next = move(dice[turn], nowPath, nowCell);
    
            if(next[1] == -1){ // 도착한 경우
                horses[i][0] = -1; // 도착 처리
                map.get(nowPath).get(nowCell).visited = false;
                dfs(turn + 1, score, end + 1); // 다음 턴
                horses[i][0] = nowPath; // 복원
                map.get(nowPath).get(nowCell).visited = true;
                continue;
            }
    
            Cell nextCell = map.get(next[0]).get(next[1]);
            if(nextCell.visited){// 이미 방문한 칸이면 이동 불가
                continue;
             } 
            if(nextCell.score == 40 && (map.get(0).get(20).visited || map.get(4).get(3).visited)){
                // 점수 40인 칸이 2개이므로 
                continue;
            }
            // 이동 처리
            map.get(nowPath).get(nowCell).visited = false; // 현재 위치 방문 해제
            nextCell.visited = true; // 다음 위치 방문 처리
            horses[i][0] = next[0];
            horses[i][1] = next[1];
    
            dfs(turn + 1, score + nextCell.score, end); // 다음 턴
    
            // 백트래킹 복원
            nextCell.visited = false;
            map.get(nowPath).get(nowCell).visited = true;
            horses[i][0] = nowPath;
            horses[i][1] = nowCell;
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        initMap();
        dfs(0, 0, 0);
        System.out.println(max);
    }
}
