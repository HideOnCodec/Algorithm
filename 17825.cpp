/*
백준 17825번 주사위 윷놀이

DFS를 이용하는 문제. 실수의 연속이었던 문제였다..
실수했던 점을 주의깊게 살필 것!

1. DFS는 매 갈림길마다 여러 길을 뻗어가면서 나아간다. 따라서 재귀호출로 파라미터를 넘겨줄 때는 함부로 전역변수로 넘겨주면 안된다.
   만약 한 갈림길에서 두 개의 길로 뻗어나갈 수 있다고 치자. 갈림길에서 주머니에 사과가 있었는데 첫번째 길로 가면 바나나를 얻고, 두번째 길로 가면 멜론을 얻는다.
   여기서 중요한 점은 내가 첫번째 길로 가든 두번째 길로 가든, 나는 무조건 출발 시점의 주머니에는 사과만 있었어야한다.
   만약 내가 DFS를 재귀적으로 호출하면서 주머니라는 변수를 전역변수로 넘기면 어떻게 될까?
   첫번째 길로 가는 경우를 따질 때 자연스레 주머니 변수에는 사과 바나나가 존재할 것이다.
   그 다음 두번째 길로 가는 경우를 따질 때 문제가 발생한다. 공평하게 주머니에는 사과만 있었어야하는데, 사과 바나나가 든 채로 두번째길을 가게된다.
   DFS, BFS에서 넘겨주는 파라미터 값 중 매 상황마다의 배열, 위치 등의 값들은 전역변수로 사용하지 않는 것이 좋다.

2. 배열을 파라미터로 넘겨주면 자연스레 전역변수처럼 된다.(배열 이름 == 배열의 시작 주소) 이 경우에는 vector를 사용하도록 하자.
3. 어이없게도 말들 인덱스를 0~4로 설정했더니, 보드에 말의 번호를 넣음으로써 위치를 기록했는데 0번 말이 들어가면 해당 위치에는 아무것도 없는 것처럼
   보이게 돼버렸다. 앞으로 보드 초기화를 0이 아닌 -1로 하거나, 그냥 말의 번호를 1~5로 설정하도록 하자.
*/

#include<iostream>
#include<vector>
using namespace std;

int dice[10];
int maxScore=0;
// 해당 칸에서 다음 칸으로 갈 수 있는 경로
vector<vector<int>> nearList = {{1},{2},{3},{4},{5},{6,21},{7},{8},{9},{10},
                            {11,24},{12},{13},{14},{15},{16,26},{17},{18},{19},{20},{32},
                            {22},{23},{29},{25},{29},{27},{28},{29},{30},{31},{20},{32}};
int score[33]={0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,
               13,16,19,22,24,28,27,26,25,30,35,0};

int move(int cur, int canMove){ // 주사위 값만큼 칸을 옮기는 함수
    // 한 번 먼저 이동
    int dest=nearList[cur][0];
    // 두 갈래길 칸이 시작지점이면 파란길 선택
    if(cur==5||cur==10||cur==15)
        dest=nearList[cur][1];

    for(int i=0; i<canMove-1; i++){
        if(dest==32)
            break;
        dest=nearList[dest][0];
    }
    
    return dest;   
}

void dfs(vector<int> pieces, int dest,int piece, int cnt, vector<int> board, int curScore){
    board[pieces[piece]]=0; // 원래 있던 자리 비우기
    board[dest]=piece; // 가야될 자리에 표시
    pieces[piece]=dest; // 현재 말 위치 갱신

    if(maxScore<curScore)
        maxScore=curScore;

    if(cnt>9) // 주사위 10번째가 끝나면 종료
        return;
    
    for(int i=1; i<=4; i++){
        if(pieces[i]!=32){ // 도착점에 없는 말이어야 함
            int next = move(pieces[i],dice[cnt]);
            if(next!=32&&board[next]!=0) // 가야될 자리에 다른 말이 있으면 안됨
                continue;
            else{
                dfs(pieces,next,i,cnt+1,board,curScore+score[next]);
            }
        }
    }
}

int main(){

    for(int i=0; i<10; i++)
        cin >> dice[i];

    vector<int> board(33,0);
    vector<int> pieces={-1,0,0,0,0};
    int next = move(0,dice[0]);
    dfs(pieces,next,1,1,board,score[next]);

    cout << maxScore;
    
}
