/*
백준 1003번 피보나치 함수

dp를 이용하는 문제이다. 메모제이션!
직접 재귀호출해봐서 풀면 시간초과이다.
*/

#include<iostream>
using namespace std;

int main(){
    int T;
    cin >> T;

    int dp[41][2];
    dp[0][0]=1, dp[0][1]=0;
    dp[1][0]=0, dp[1][1]=1;

    for(int i=2; i<41; i++){
        dp[i][0]=dp[i-1][0]+dp[i-2][0];
        dp[i][1]=dp[i-1][1]+dp[i-2][1];
    }

    for(int i=0; i<T; i++){
        int N;
        cin >> N;
        cout << dp[N][0] << ' ' << dp[N][1] << endl;
    }
}
