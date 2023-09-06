/*
백준 28703번 Double It

우선순위 큐를 이용한 문제.
가장 중요한 것은 "언제"까지 최댓값, 최솟값의 차이를 구하냐는 것이다.
초기 배열의 최댓값보다 현재 minQ에 들어있는 최솟값이 커지게 되면 탐색을 종료한다.
이유 : 현재 minQ의 최솟값이 초기 최댓값보다 커진다는 것은 결국 초기 배열의 모든 수가 한번씩 2가 곱해진 것이다.
최댓값과 최솟값의 가장 작은 차이를 구하는 것이 목적인데, 초기 최댓값마저 2를 곱해지면 차이가 작아지는 것이 아닌 오히려 커져버리기 때문이다.
*/

#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main(){
    int N;
    cin >> N;
    vector<int> A(N);
    for(int i=0; i<N; i++)
        scanf("%d",&A[i]);
    
    priority_queue<int,vector<int>,greater<int>> minQ; // 오름차순
    priority_queue<int> maxQ; // 내림차순
    vector<int> minList;
    
    for(int i=0; i<N; i++){
        minQ.push(A[i]);
        maxQ.push(A[i]);
    }
    int diff = maxQ.top()-minQ.top();
    minList.push_back(diff);

    int initMax=maxQ.top();
    while(minQ.top()<initMax){
        int minValue = minQ.top()*2;
        if(minValue>maxQ.top()){
            maxQ.push(minValue);
        }
        minQ.pop();
        minQ.push(minValue);
        diff = maxQ.top()-minQ.top();
        minList.push_back(diff);
    }
    int minValue = minList[0];
    for(int i=0; i<minList.size(); i++){
        if(minValue>minList[i]) minValue = minList[i];
    }

    cout << minValue;
}
