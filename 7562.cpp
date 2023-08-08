/*
백준 7562번 나이트의 이동

BFS를 이용하여 해결한다.
체스가 이동할 수 있는 경우를 dx, dy 배열에 각각 받아 구현한다.
현재 위치와 목표 위치를 각각 cur, dest로 받아 BFS에 넘긴다(pair 이용)
테스트 케이스마다 BFS를 호출하며 visit 배열 대신 board로 2차원 벡터를 구현한다.
큐에 처음 위치를 넣고 큐가 빌때까지 차례대로 갈 수 있는 위치를 넣으며 BFS를 실행한다.(단 갈 수 있는 위치가 범위 안에 있고, 방문하지 않아야한다)

어차피 BFS는 '동일선상에서 출발한다'라는 걸 기억하고, 경로의 횟수 비교를 해줄 필요가 없다. (어차피 먼저 도착하는 그 순간이 최소 경로이기 때문이다)
단 DFS이면 경로 횟수 비교를 해줘야할 것이다.


*/

#include<iostream>
#include<utility>
#include<queue>
using namespace std;

int T,I; // 테스트 케이스, 한 변
int dx[8]={1,2,2,1,-1,-2,-2,-1}; 
int dy[8]={2,1,-1,-2,-2,-1,1,2};

int BFS(pair<int,int> cur,pair<int,int> dest){
    vector<vector<int>> board(I,vector<int>(I,0));
    queue<pair<int,int>> queue;
    queue.push(cur);
    board[cur.first][cur.second] = 1;

    while(!queue.empty()){
        pair<int,int> knight = queue.front();
        queue.pop();

        if(knight.first==dest.first && knight.second==dest.second){
            return board[knight.first][knight.second];
        }
        for(int i=0; i<8; i++){
            int moveRow = knight.first+dy[i];
            int moveCol = knight.second+dx[i];
            if((0<=moveRow&&moveRow<I)&&(0<=moveCol&&moveCol<I)){
                if(board[moveRow][moveCol]==0){
                    pair<int,int> tmp;
                    tmp.first = moveRow, tmp.second = moveCol;
                    queue.push(tmp);
                    board[moveRow][moveCol]=board[knight.first][knight.second]+1;
                }
            }
        }
    }
}

int main(){
    cin >> T;
    pair<int,int> cur;
    pair<int,int> dest;
    for(int i=0; i<T; i++){
        cin >> I;
        cin >> cur.second >> cur.first; // col, row
        cin >> dest.second >> dest.first; // col, row
        cout << BFS(cur,dest)-1 << '\n';
    }
}
