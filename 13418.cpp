/*
백준 13418번 학교 탐방하기 

최소신장트리(크루스칼 알고리즘)을 이용한 문제이다.(사이클이 없어야함)
크루스칼 알고리즘이 뭔지 배우고나서 union find를 이용하여 코드를 구현할 수 있으면 쉽게 풀 수 있다.
간선의 비용을 오름차순 또는 내림차순으로 정렬하느냐에 따라 최소신장트리 혹은 최대신장트리가 될 수 있다.
*/

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int root[1001];
int N,M;
class Edge{
public:
        int node[2];
        int cost;

        Edge(int a, int b, int cost){
            this->node[0]=a;
            this->node[1]=b;
            this->cost=cost;
        }
};

bool desc(Edge e1, Edge e2){
    return e1.cost > e2.cost;
}

bool asc(Edge e1, Edge e2){
    return e1.cost < e2.cost;
}

int getParent(int node){ // 부모 노드 구하기
    if(root[node]==node) return node;
    return getParent(root[node]);
}

void unionSet(int a, int b){ // a노드 b노드 union
    a = getParent(a);
    b = getParent(b);
    if(a<b) root[b]=a;
    else root[a]=b;
}

bool isCycle(int a, int b){ // 사이클 존재 여부 판단
    if(getParent(a)==getParent(b))
        return true;
    else return false;
}

int kruskal(vector<Edge> edgeList){
    for(int i=0;i<=N;i++)
            root[i]=i;
    int cnt=0;
    for(int i=0; i<edgeList.size(); i++){
        if(!isCycle(edgeList[i].node[0],edgeList[i].node[1])){
            if(edgeList[i].cost==0) cnt++;
            unionSet(edgeList[i].node[0],edgeList[i].node[1]);
        }
    }

    return cnt;
}

int main(){
    cin >> N >> M;

    vector<Edge> edgeList;

    for(int i=0; i<M+1; i++){
        int A,B,C;
        cin >> A >> B >> C;
        edgeList.push_back(Edge(A,B,C));
    }
    // 최소 피로도
    sort(edgeList.begin(),edgeList.end(),desc);
    int min=kruskal(edgeList);

    // 최대 피로도
    sort(edgeList.begin(),edgeList.end(),asc);
    int max=kruskal(edgeList);

    cout << max*max - min*min;
}
