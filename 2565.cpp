/*
백준 2565번 전깃줄

dp를 이용한 문제. 생각의 전환을 해보자
최소로 없애야 하는 전깃줄의 개수 = 전체 - 최대로 있을 수 있는 전깃줄 개수
*/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool compare(vector<int> a, vector<int> b){
    return a[0] < b[0];
}

int main(){
    int N;
    cin >> N;
    vector<vector<int>> arr(N,vector<int>(2));
    vector<int> dp(N,1);
    for(int i=0; i<N; i++)
        cin >> arr[i][0] >> arr[i][1];

    
    sort(arr.begin(),arr.end(),compare);
    for(int i=0; i<N; i++){
        for(int j=0; j<i; j++){
            if(arr[i][1]>arr[j][1]&&dp[j]+1>dp[i])
                dp[i]=dp[j]+1;
        }
    }
    int max=0;
    for(int i=0; i<N; i++){
        if(max<dp[i])
            max=dp[i];
    }
    cout << N - max;
}
