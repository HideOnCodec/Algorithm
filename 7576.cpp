/*
백준 7576번 토마토

BFS를 이용한 문제이다.
토마토 배열을 돌다가 익은 걸 발견하면 BFS를 돌리고, 방문 경로의 횟수를 1씩 늘리며 저장한다.
중요한 건 각 배열을 돌면서 익은 토마토가 있을 때 BFS를 바로 호출하면 안된다.
이 방식으로 하게 되면 이미 visit 배열이 1 이상인 토마토를 만나면 크기 비교를 통해 경로 횟수를 저장해야한다.

BFS는 동일 선상에서 출발하여 경로를 찾아간다는 걸 잊지 말자.
각 익은 토마토를 처음에 큐에 미리 넣어놓고, BFS를 해야한다.
*/

#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int M,N;    
int tomato[1000][1000];
int visit[1000][1000];
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

void BFS(queue<vector<int>> queue){

    while(!queue.empty()){
        vector<int> node = queue.front(); // node[0] : row, node[1] : col
        queue.pop();

        for(int i=0; i<4; i++){
            int moveRow=node[0]+dx[i];
            int moveCol=node[1]+dy[i];
            if((0<=moveRow&&moveRow<N )&&(0<=moveCol&&moveCol<M)&&(tomato[moveRow][moveCol]!=-1)&&(visit[moveRow][moveCol]==0)){
                vector<int> tmp = {moveRow,moveCol};
                queue.push(tmp);
                visit[moveRow][moveCol]=visit[node[0]][node[1]]+1;
            }
        }
    }
}

int main(){
    cin >> M >> N;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> tomato[i][j];
            if(tomato[i][j]==-1)
                visit[i][j]=-1;
            if(tomato[i][j]==1)
                visit[i][j]=1;
        }
    }
    queue<vector<int>> queue;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(tomato[i][j]==1){
                vector<int> point = {i,j};
                queue.push(point);   
            }
        }
    }

    BFS(queue);

    int max=0;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(visit[i][j]==0){
                cout << -1;
                return 0;
            }
            if(max<visit[i][j])
                max=visit[i][j];
        }
    }
    cout << max-1;

}
