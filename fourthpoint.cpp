/*
백준 3009번 네 번째 점

점들을 오름차순으로 정렬한다. 만약 1번 점과 2번 점의  x가 같으면 
구하는 네번 째 점은 자연스레 3번 점의 x와 같아진다.
2번 3번 점이 같을 경우는 1번 점의 x와 같아진다.
각 y를 비교하여 네번 째 점을 구한다.

*/


#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

bool sorting(vector<int> &v1, vector<int> &v2){
    if(v1[0] == v2[0]){
        return v1[1] < v2[1];
    }
    else return v1[0] < v2[0];
}
int main(void){
    vector<vector<int>> v(3);
    for(int i=0; i<3; i++){
        int x,y;
        cin >> x >> y;
        v[i].push_back(x), v[i].push_back(y);
    }

    sort(v.begin(),v.end(),sorting);

    if(v[0][0]==v[1][0]){
        if(v[2][1]==v[1][1]) // 정답은 하단 오른쪽 점
            cout << v[2][0] << ' ' << v[0][1];
        else // 정답은 상단 오른쪽 점
            cout << v[2][0] << ' ' << v[1][1];
    }
    else{
        if(v[0][1]==v[1][1]) // 정답은 상단 왼쪽 점
            cout << v[0][0] << ' ' << v[2][1];
        else // 정답은 하단 왼쪽 점
            cout << v[0][0] << ' ' << v[1][1];
    }

}
