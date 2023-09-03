/*
백준 2662번 기업투자

dp를 이용한 배낭문제이다.
배낭문제는 0-1배낭 문제이며 중복이 불가능한 것이다.
0-1배낭문제는 두 가지, 물건이 각각 1개씩만 있는 중복 불가와, 물건이 각각 여러개씩 있는 중복 가능으로 나뉜다.
중복이 불가능하면 dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i])가 되고
중복이 가능하면 dp[i][j]=max(dp[i][j],dp[i][j-w[i]]+v[i])가 될것이다.
이 문제는 예제로 설명하면 1원짜리 5(A), 1원짜리 1(B), 2원짜리 6(A), 2원짜리 5(B)...가
각각 하나의 물건이라고 생각하고 점화식을 세워야한다.
단, 같은 기업끼리 분산 투자할 수 없으므로 하나의 기업에 해당하는 물건들을
group이라는 배열로 묶어줘서 따져야한다.
즉 다른 기업끼리도 비교하고, 하나의 기업에서의 여러 물건들끼리도 비교하는 것이다.

그리고 최대 가치가 나왔을 때, 어디에 투자했는지는 경로를 따라가면 된다.
각 dp 배열을 채울 때 마다 몇 원에 해당하는지를 path 배열에 저장하고
최대 가치 부분을 시작으로 해당하는 투자 액수를 뺀 만큼의 이전 dp 배열을 따라간다.
즉 점화식을 세우면 dp[i][j]를 while문을 통해 i=i-1,j=j-현재 투자한 돈을 빼주면서 따라가면
투자한 기업의 경로를 알 수 있다. 
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,M; 

int main(){
    cin >> N >> M;
    int dp[M+1][N+1];
    int path[M+1][N+1];
    vector<vector<int>> group(M+1);
    for(int i=0; i<N; i++){
        int n;
        cin >> n;
        for(int j=0; j<M; j++){
            int profit;
            cin >> profit;
            group[j].push_back(profit);
        }
    }
    for(int i=0; i<M+1; i++){
        for(int j=0; j<N+1; j++){
            dp[i][j]=0;
            path[i][j]=0;
        }
    }
    for(int i=1; i<=M; i++){
        for(int j=1; j<=N; j++){
            dp[i][j]=dp[i-1][j];
            for(int c=1; c<=j; c++){ // 현재 c+1원, 최대 j원까지
                if(dp[i][j]<dp[i-1][j-c]+group[i-1][c-1]){
                    dp[i][j]=dp[i-1][j-c]+group[i-1][c-1];
                    path[i][j]=c;
                }
            }
        }
    }
    vector<int> answer;
    int i=M, j=N;
    while(i>0){
        answer.push_back(path[i][j]);
        j-=path[i][j];
        i--;
    }
    cout << dp[M][N] << endl;
    reverse(answer.begin(),answer.end());
    for(auto item : answer)
        cout << item << ' ';
}
