/*
백준 1260번 DFS와BFS

DFS는 stack 사용하고 BFS는 큐 사용해서 풀면된다.
이 때 DFS stack 사용할 때는 출력에 주의해야한다. 첫 노드 출력하고 다음 노드들 출력을 따로 해줘야한다.
그리고 stack을 사용할 때는 방문하지 않은 노드가 나오면 현재 노드, 해당 노드 둘다 push하고 break를 꼭 걸어줘야한다.
(현재노드를 push하는 이유는 break를 걸었기 때문에 남은 인접노드들을 방문하지 못했기 때문이다. 나중에 다시 방문해야한다.)
*/

#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<stack>
using namespace std;

int N,M,V;

void DFS(int n,vector<vector<int>> &nearList){
    vector<bool> visit(N+1,false);
    stack<int> stack;
    stack.push(n);
    visit[n]=true;
    cout << n << ' ';
    while(!stack.empty()){
        int node = stack.top();

        stack.pop();
        // 차례대로 인접 노드 탐색
        for(int i=0; i<nearList[node].size(); i++){
            if(visit[nearList[node][i]]==false){
                cout << nearList[node][i] << ' ';
                stack.push(node);
                stack.push(nearList[node][i]);
                visit[nearList[node][i]]=true;
                break;
            }
        }
    }
    cout << '\n';

}
void BFS(int n,vector<vector<int>> &nearList){
    vector<bool> visit(N+1,false);
    queue<int> queue;
    queue.push(n);
    visit[n]=true;

    while(!queue.empty()){
        int node = queue.front();
        queue.pop();
        cout << node << ' ';
        // 차례대로 인접 노드 탐색
        for(int i=0; i<nearList[node].size(); i++){
            if(visit[nearList[node][i]]) // 이미 방문한 노드이면
                continue;
            else{
                queue.push(nearList[node][i]);
                visit[nearList[node][i]]=true;
            }
        }
    }
    cout << '\n';

}
int main(){
    cin >> N >> M >> V;
    vector<vector<int>> nearList(N+1); // 각 노드별 인접 노드 리스트

    for(int i=0; i<M; i++){
        int left,right;
        cin >> left >> right;
        nearList[left].push_back(right);
        nearList[right].push_back(left); // 실수 : 간선 양쪽 정점 서로 넣어줘야한다!!
    }
    for(int i=1; i<=N; i++){
        sort(nearList[i].begin(),nearList[i].end());
    }
    DFS(V,nearList);
    for(int i=1; i<=N; i++){
        sort(nearList[i].begin(),nearList[i].end());
    }
    BFS(V,nearList);

}
