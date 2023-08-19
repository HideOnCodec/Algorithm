/*
백준 13398번 연속합 2
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> dp(100001,0);
vector<int> list;
vector<int> answer;

int N;
int maxValue=0;
int after(int index){
    maxValue=0;
    int sum=0;
    for(int i=index; i<N; i++){
        sum+=list[i];
        if(maxValue<sum)
            maxValue=sum;
    }
    return maxValue;
}

int main(){
    cin >>  N;

    for(int i=0; i<N; i++){
        int n;
        cin >> n;
        list.push_back(n);
    }

    dp[0]=list[0];
    answer.push_back(dp[0]);
    for(int i=1; i<N; i++){
        if(dp[i-1]+list[i]<list[i]){
            dp[i]=list[i];
        }
        else{
            if(list[i]<0 && i<N-1){
                int afterValue = after(i+1);
                answer.push_back(afterValue+dp[i-1]);
            }
            dp[i]=list[i]+dp[i-1];

        }
        answer.push_back(dp[i]);
    }  
    int result = *max_element(answer.begin(),answer.end());
    cout << result;
}
